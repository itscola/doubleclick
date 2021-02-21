package top.whitecola;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mumfrey.liteloader.Configurable;
import com.mumfrey.liteloader.Tickable;
import com.mumfrey.liteloader.core.LiteLoader;
import com.mumfrey.liteloader.modconfig.ConfigPanel;
import com.mumfrey.liteloader.modconfig.ConfigStrategy;
import com.mumfrey.liteloader.modconfig.ExposableOptions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerLoginClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import top.whitecola.keys.LongLeftClickKeyBinding;
import top.whitecola.keys.OnceLeftClick;

import java.io.File;
import java.net.Socket;

/**
 * This is a very simple doubleclick2 LiteMod, it draws an analogue clock on the
 * minecraft HUD using a traditional onTick hook supplied by LiteLoader's
 * {@link Tickable} interface.
 *
 * @author Adam Mummery-Smith
 */
@ExposableOptions(strategy = ConfigStrategy.Versioned, filename="litemod.json")
public class LiteModDoubleClickMod implements Tickable, Configurable
{
    boolean leftlonglick = false;
    /**
     * This is our instance of Clock which we will draw every tick
     */

    /**
     * This is a keybinding that we will register with the game and use to
     * toggle the clock
     * 
     * Notice that we specify the key name as an *unlocalised* string. The
     * localisation is provided from the included resource file.
     */

    @Expose
    @SerializedName("clock_size")
    private int clockSize = 64;
    
    @Expose
    @SerializedName("clock_visible")
    private boolean clockVisible = true;
    
    /**
     * Default constructor. All LiteMods must have a default constructor. In
     * general you should do very little in the mod constructor EXCEPT for
     * initialising any non-game-interfacing components or performing sanity
     * checking prior to initialisation
     */
    public LiteModDoubleClickMod()
    {

    }
    
    /**
     * getName() should be used to return the display name of your mod and MUST
     * NOT return null
     * 
     * @see com.mumfrey.liteloader.LiteMod#getName()
     */
    @Override
    public String getName()
    {
        return "HelloServer";
    }
    
    /**
     * getVersion() should return the same version string present in the mod
     * metadata, although this is not a strict requirement.
     * 
     * @see com.mumfrey.liteloader.LiteMod#getVersion()
     */
//    @Override
//    public String getVersion()
//    {
//        return "0.0.0";
//    }
    
//    @Override
//    public Class<? extends ConfigPanel> getConfigPanelClass()
//    {
//        return null;
//    }
//

    @Override
    public String getVersion() {
        return "1.0";
    }

    /**
     * init() is called very early in the initialisation cycle, before the game
     * is fully initialised, this means that it is important that your mod does
     * not interact with the game in any way at this point.
     * 
     * @see com.mumfrey.liteloader.LiteMod#init(java.io.File)
     */
    @Override
    public void init(File configPath)
    {
        // The key binding declared above won't do anything unless we register
        // it, LiteLoader's Input manager provides a convenience method for this
        new OnceLeftClick();
        new LongLeftClickKeyBinding();
    }

    @Override
    public void upgradeSettings(String version, File configPath, File oldConfigPath) {

    }

    @Override
    public Class<? extends ConfigPanel> getConfigPanelClass() {
        return null;
    }

    @Override
    public void onTick(Minecraft minecraft, float partialTicks, boolean inGame, boolean clock) {



        if(LongLeftClickKeyBinding.click.isPressed()){
            if(leftlonglick){
                leftlonglick = false;
            }else{
                leftlonglick = true;
            }
            KeyBinding.setKeyBindState(-100, leftlonglick);

        }



    }

    /**
     * upgradeSettings is used to notify a mod that its version-specific
     * settings are being migrated
     * 
     * @see com.mumfrey.liteloader.LiteMod#upgradeSettings(java.lang.String,
     *         java.io.File, java.io.File)
     */
//    @Override
//    public void upgradeSettings(String version, File configPath, File oldConfigPath)
//    {
//    }
    
//    @Override
//    public void onTick(Minecraft minecraft, float partialTicks, boolean inGame, boolean clock)
//    {
        // The three checks here are critical to ensure that we only draw the
        // clock as part of the "HUD" and don't draw it over active GUI's or
        // other elements

                
                // Our @Expose annotations control what properties get saved,
                // this tells liteloader to actually write properties to disk

//    }
    
//    boolean getClockVisibility()
//    {
//        return true;
//    }
//
//    void setClockVisibility(boolean visible)
//    {
//
//    }
}
