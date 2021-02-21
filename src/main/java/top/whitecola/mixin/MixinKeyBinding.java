package top.whitecola.mixin;

import net.minecraft.client.settings.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.whitecola.keys.OnceLeftClick;

@Mixin(KeyBinding.class)
public class MixinKeyBinding {

    @Shadow private int pressTime;

    @Inject(at=@At(value="HEAD"),method = "onTick",cancellable = true)
    private static void onTick(int keyCode, CallbackInfo ci){

    }

    @Inject(at=@At(value="HEAD"),method = "setKeyBindState",cancellable = true)
    private static void setKeyBindState(int keyCode, boolean pressed, CallbackInfo ci){
        if(keyCode == OnceLeftClick.click.getKeyCode()){
            KeyBinding.onTick(-100);
            ci.cancel();
            return;
        }
    }

}
