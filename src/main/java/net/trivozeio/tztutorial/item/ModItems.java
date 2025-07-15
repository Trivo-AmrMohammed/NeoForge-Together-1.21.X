package net.trivozeio.tztutorial.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trivozeio.tztutorial.TZtutorial;

import java.util.TimeZone;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TZtutorial.MODID);

    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> POLISHED_RUBY = ITEMS.register("polished_ruby",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
