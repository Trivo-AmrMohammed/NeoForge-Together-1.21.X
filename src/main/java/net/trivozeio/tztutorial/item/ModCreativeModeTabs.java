package net.trivozeio.tztutorial.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trivozeio.tztutorial.TZtutorial;
import net.trivozeio.tztutorial.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TZtutorial.MODID);

    public static final Supplier<CreativeModeTab> TZTUTORIAL_ITEMS_TAB =
            CREATIVE_MODE_TAB.register("tztutorial_items_tab", () -> CreativeModeTab.builder().icon(()
                    -> new ItemStack(ModItems.OSMIUM.get())).title(Component.translatable("creativetab.tztutorial.tz_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.OSMIUM);
                        output.accept(ModItems.RAW_OSMIUM);
                        output.accept(ModItems.RUBY);
                        output.accept(ModItems.POLISHED_RUBY);
                    }).build());

    public static final Supplier<CreativeModeTab> TZTUTORIAL_BLOCKS_TAB =
            CREATIVE_MODE_TAB.register("tztutorial_blocks_tab", () -> CreativeModeTab.builder().icon(()
                            -> new ItemStack(ModBlocks.OSMIUM_BLOCK.get())).title(Component.translatable("creativetab.tztutorial.tz_blocks"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TZtutorial.MODID, "tz_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.OSMIUM_BLOCK);
                        output.accept(ModBlocks.OSMIUM_ORE);
                        output.accept(ModBlocks.RUBY_ORE);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
