package com.github.Debris.GAHigher.util;

import com.github.Debris.GAHigher.api.ConditionalMixin;
import moddedmite.rustedironcore.api.util.FabricUtil;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;
import net.fabricmc.loader.api.metadata.version.VersionPredicate;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.service.MixinService;
import org.spongepowered.asm.util.Annotations;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class MixinConditionUtil {
    public static boolean check(String mixinClassName) {
        ClassNode classNode;
        try {
            classNode = MixinService.getService().getBytecodeProvider().getClassNode(mixinClassName);
        } catch (ClassNotFoundException | IOException e) {
            return true;
        }

        AnnotationNode annotationNode = Annotations.getVisible(classNode, ConditionalMixin.class);

        if (annotationNode == null) return true;// no condition

        List<AnnotationNode> require = Annotations.getValue(annotationNode, "require", true);
        for (AnnotationNode condition : require) {
            if (!checkAnnotation(condition)) return false;
        }

        List<AnnotationNode> conflict = Annotations.getValue(annotationNode, "conflict", true);
        for (AnnotationNode condition : conflict) {
            if (checkAnnotation(condition)) return false;
        }

        return true;
    }

    private static boolean checkAnnotation(AnnotationNode condition) {
        String value = Annotations.getValue(condition, "value");
        String versionPredicate = Annotations.getValue(condition, "versionPredicate", "*");
        return checkCondition(value, versionPredicate);
    }

    private static boolean checkCondition(String value, String versionPredicate) {
        Optional<ModContainer> modContainer = FabricUtil.getModContainer(value);
        if (modContainer.isEmpty()) return false;
        try {
            VersionPredicate parse = VersionPredicate.parse(versionPredicate);
            Version realVersion = modContainer.get().getMetadata().getVersion();
            return parse.test(realVersion);
        } catch (VersionParsingException e) {
            return true;
        }
    }
}
