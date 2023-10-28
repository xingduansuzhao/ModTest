package com.xdsz.test.items;

import com.xdsz.test.Test;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(Test.TAB));
    }
}
