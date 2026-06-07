package lv.id.bonne.animalpen.expansion.roots;

import lv.id.bonne.animalpen.expansion.roots.functions.SproutGiftFunction;
import lv.id.bonne.animalpen.processing.function.wrapper.EntityFunctionEntry;
import lv.id.bonne.animalpen.registries.AnimalPenFunctionRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(AnimalPenExpansionRoots.MOD_ID)
public class AnimalPenExpansionRoots
{
    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public AnimalPenExpansionRoots(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        ENTITY_FUNCTIONS.register(modEventBus);
    }


    public static final DeferredRegister<EntityFunctionEntry> ENTITY_FUNCTIONS =
        DeferredRegister.create(AnimalPenFunctionRegistry.ENTITY_FUNCTIONS_REGISTRY_KEY, AnimalPenExpansionRoots.MOD_ID);


    public static final Supplier<EntityFunctionEntry> SPROUT_GIFT =
        ENTITY_FUNCTIONS.register("sprout_gift", () ->
            new EntityFunctionEntry(new SproutGiftFunction())
        );

    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "animal_pen_expansion_roots";
}
