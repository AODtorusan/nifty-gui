package de.lessvoid.nifty.examples.all;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.batch.BatchRenderDevice;
import de.lessvoid.nifty.examples.LwjglInitHelper;
import de.lessvoid.nifty.examples.NiftyExample;
import de.lessvoid.nifty.renderer.lwjgl.render.batch.LwjglBatchRenderBackend;
import de.lessvoid.nifty.sound.openal.OpenALSoundDevice;
import de.lessvoid.nifty.spi.time.impl.AccurateTimeProvider;

import javax.annotation.Nonnull;

/**
 * The Nifty Examples.
 * @author void
 */
public class AllExamplesMain implements NiftyExample {

  /**
   * file of the main program.
   */
  private static final String ALL_INTRO_XML = "all/intro.xml";
  
  private final String startScreen;


  public AllExamplesMain() {
    this("start");
  }

  private AllExamplesMain(final String screen) {
    startScreen = screen;
  }

  /**
   * Main method.
   * @param args arguments
   */
  public static void main(@Nonnull final String[] args) {
    if (!LwjglInitHelper.initSubSystems("Nifty Examples")) {
      System.exit(0);
    }

    BatchRenderDevice renderDevice = new BatchRenderDevice(new LwjglBatchRenderBackend(), 2048, 2048);
//    renderDevice.enableLogFPS();

    // create nifty
    Nifty nifty = new Nifty(
//        new LwjglRenderDevice(),
        renderDevice,
        new OpenALSoundDevice(),
        LwjglInitHelper.getInputSystem(),
        new AccurateTimeProvider());
    if (args.length == 1) {
      nifty.fromXml(ALL_INTRO_XML, args[0]);
    } else {
      nifty.fromXml(ALL_INTRO_XML, "start");
    }

    boolean done = false;
    while (!done) {
      LwjglInitHelper.renderLoop(nifty, null);
      done = true;
    }

    LwjglInitHelper.destroy();
  }

  @Override
  public String getStartScreen() {
    return startScreen;
  }

  @Nonnull
  @Override
  public String getMainXML() {
    return ALL_INTRO_XML;
  }

  @Nonnull
  @Override
  public String getTitle() {
    return "Nifty Examples";
  }

  @Override
  public void prepareStart(Nifty nifty) {
    // nothing to do
  }
}
