package com.github.debris.gah.item;

import net.minecraft.Item;

public class RepeatRecipe {
    Item input;
    boolean is3X3;
    int itemID;
    int meta;
    int ratio;


    public static final class RepeatRecipeBuilder {
        private Item input;
        private boolean is3X3;
        private int itemID;
        private int meta;
        private int ratio;

        public RepeatRecipeBuilder() {
        }

        public RepeatRecipeBuilder(RepeatRecipe other) {
            this.input = other.input;
            this.is3X3 = other.is3X3;
            this.itemID = other.itemID;
            this.meta = other.meta;
            this.ratio = other.ratio;
        }

        public static RepeatRecipeBuilder aRepeatRecipe() {
            return new RepeatRecipeBuilder();
        }

        public RepeatRecipeBuilder input(Item input) {
            this.input = input;
            return this;
        }

        public RepeatRecipeBuilder is3X3(boolean is3X3) {
            this.is3X3 = is3X3;
            return this;
        }

        public RepeatRecipeBuilder itemID(int itemID) {
            this.itemID = itemID;
            return this;
        }

        public RepeatRecipeBuilder meta(int meta) {
            this.meta = meta;
            return this;
        }

        public RepeatRecipeBuilder ratio(int ratio) {
            this.ratio = ratio;
            return this;
        }

        public RepeatRecipe build() {
            RepeatRecipe repeatRecipe = new RepeatRecipe();
            repeatRecipe.meta = this.meta;
            repeatRecipe.itemID = this.itemID;
            repeatRecipe.is3X3 = this.is3X3;
            repeatRecipe.input = this.input;
            repeatRecipe.ratio = this.ratio;
            return repeatRecipe;
        }
    }
}
