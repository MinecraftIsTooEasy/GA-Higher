package com.github.Debris.GAHigher.util;

import net.minecraft.IRecipe;

import java.util.Comparator;

public class RecipeSorter implements Comparator<IRecipe> {
    public int compare(IRecipe var1, IRecipe var2) {
        if (var1 instanceof net.minecraft.ShapelessRecipes && var2 instanceof net.minecraft.ShapedRecipes)
            return 1;
        if (var2 instanceof net.minecraft.ShapelessRecipes && var1 instanceof net.minecraft.ShapedRecipes)
            return -1;
        if (var2.getRecipeSize() < var1.getRecipeSize())
            return -1;
        return (var2.getRecipeSize() > var1.getRecipeSize()) ? 1 : 0;
    }
}
