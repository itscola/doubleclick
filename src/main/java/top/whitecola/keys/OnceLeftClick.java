package top.whitecola.keys;

import com.mumfrey.liteloader.core.LiteLoader;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class OnceLeftClick {
    public static KeyBinding click;

    public OnceLeftClick(){
        click = new KeyBinding("key.doubleclick.onceleftclick",Keyboard.KEY_K ,"key.categories.doubleclick");
        LiteLoader.getInput().registerKeyBinding(click);
    }
}
