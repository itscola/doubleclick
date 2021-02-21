package top.whitecola.keys;

import com.mumfrey.liteloader.core.LiteLoader;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class LongLeftClickKeyBinding {
    public static KeyBinding click;

    public LongLeftClickKeyBinding()
    {
        LongLeftClickKeyBinding.click = new KeyBinding("key.doubleclick.longleftclick", Keyboard.KEY_I, "key.categories.doubleclick");

        LiteLoader.getInput().registerKeyBinding(LongLeftClickKeyBinding.click);
    }
}
