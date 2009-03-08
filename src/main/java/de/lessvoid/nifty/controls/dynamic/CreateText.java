package de.lessvoid.nifty.controls.dynamic;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyIdCreator;
import de.lessvoid.nifty.controls.StandardControl;
import de.lessvoid.nifty.controls.dynamic.attributes.ControlAttributes;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.screen.Screen;

public class CreateText extends ControlAttributes {
  public CreateText(final String text) {
    setId(NiftyIdCreator.generate());
    setText(text);
  }

  public CreateText(final String id, final String text) {
    setId(id);
    setText(text);
  }

  public Element create(
      final Nifty nifty,
      final Screen screen,
      final Element parent) {
    nifty.addControl(screen, parent, new StandardControl() {
      public Element createControl(final Nifty nifty, final Screen screen, final Element parent) throws Exception {
        return createText(nifty, screen, parent);
      }
    });
    nifty.addControlsWithoutStartScreen();
    return parent.findElementByName(attributes.get("id"));
  }
}