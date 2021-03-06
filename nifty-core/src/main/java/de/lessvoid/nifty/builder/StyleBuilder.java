package de.lessvoid.nifty.builder;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.dynamic.attributes.ControlAttributes;
import de.lessvoid.nifty.controls.dynamic.attributes.ControlEffectsAttributes;
import de.lessvoid.nifty.loaderv2.types.StyleType;
import de.lessvoid.nifty.tools.Color;
import de.lessvoid.xml.xpp3.Attributes;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;

public class StyleBuilder {
  @Nonnull
  private final Attributes styleAttributes = new Attributes();
  @Nonnull
  private final ControlAttributes attributes = new ControlAttributes();
  @Nonnull
  private final Collection<EffectBuilder> onStartScreen = new ArrayList<EffectBuilder>();
  @Nonnull
  private final Collection<EffectBuilder> onEndScreen = new ArrayList<EffectBuilder>();
  @Nonnull
  private final Collection<HoverEffectBuilder> onHover = new ArrayList<HoverEffectBuilder>();
  @Nonnull
  private final Collection<HoverEffectBuilder> onStartHover = new ArrayList<HoverEffectBuilder>();
  @Nonnull
  private final Collection<HoverEffectBuilder> onEndHover = new ArrayList<HoverEffectBuilder>();
  @Nonnull
  private final Collection<EffectBuilder> onClick = new ArrayList<EffectBuilder>();
  @Nonnull
  private final Collection<EffectBuilder> onFocus = new ArrayList<EffectBuilder>();
  @Nonnull
  private final Collection<EffectBuilder> onLostFocus = new ArrayList<EffectBuilder>();
  @Nonnull
  private final Collection<EffectBuilder> onGetFocus = new ArrayList<EffectBuilder>();
  @Nonnull
  private final Collection<EffectBuilder> onActive = new ArrayList<EffectBuilder>();
  @Nonnull
  private final Collection<EffectBuilder> onCustom = new ArrayList<EffectBuilder>();
  @Nonnull
  private final Collection<EffectBuilder> onShow = new ArrayList<EffectBuilder>();
  @Nonnull
  private final Collection<EffectBuilder> onHide = new ArrayList<EffectBuilder>();

  public enum ChildLayoutType {
    Vertical("vertical"), Horizontal("horizontal"), Center("center"), Absolute("absolute"),
    AbsoluteInside("absolute-inside"), Overlay("overlay");

    private final String layout;

    private ChildLayoutType(final String layout) {
      this.layout = layout;
    }

    public String getLayout() {
      return layout;
    }
  }

  public enum Align {
    Left("left"), Right("right"), Center("center");

    private final String align;

    private Align(final String align) {
      this.align = align;
    }

    public String getLayout() {
      return align;
    }
  }

  public enum VAlign {
    Top("top"), Bottom("bottom"), Center("center");

    private final String valign;

    private VAlign(final String valign) {
      this.valign = valign;
    }

    public String getLayout() {
      return valign;
    }
  }

  // these two attributes are applied directly to the style (<style id="this" base="another">)

  public void id(@Nonnull final String id) {
    styleAttributes.set("id", id);
  }

  public void base(@Nonnull final String baseStyle) {
    styleAttributes.set("base", baseStyle);
  }

  // all other attributes are applied to the attribute tag (<style><attributes .../></style>)

  public void name(@Nonnull final String name) {
    attributes.setName(name);
  }

  public void backgroundColor(@Nonnull final String backgroundColor) {
    attributes.setBackgroundColor(backgroundColor);
  }

  public void backgroundColor(@Nonnull final Color backgroundColor) {
    attributes.setBackgroundColor(backgroundColor.getColorString());
  }

  public void color(@Nonnull final String color) {
    attributes.setColor(color);
  }

  public void color(@Nonnull final Color color) {
    attributes.setColor(color.getColorString());
  }

  public void selectionColor(@Nonnull final String color) {
    attributes.setSelectionColor(color);
  }

  public void selectionColor(@Nonnull final Color color) {
    attributes.setSelectionColor(color.getColorString());
  }

  public void text(@Nonnull final String text) {
    attributes.setText(text);
  }

  public void backgroundImage(@Nonnull final String backgroundImage) {
    attributes.setBackgroundImage(backgroundImage);
  }

  public void imageMode(@Nonnull final String imageMode) {
    attributes.setImageMode(imageMode);
  }

  public void inset(@Nonnull final String inset) {
    attributes.setInset(inset);
  }

  public void inputMapping(@Nonnull final String inputMapping) {
    attributes.setInputMapping(inputMapping);
  }

  public void style(@Nonnull final String style) {
    attributes.setStyle(style);
  }

  public void childLayout(@Nonnull final ChildLayoutType childLayout) {
    attributes.setChildLayout(childLayout.getLayout());
  }

  public void childLayoutVertical() {
    childLayout(ChildLayoutType.Vertical);
  }

  public void childLayoutHorizontal() {
    childLayout(ChildLayoutType.Horizontal);
  }

  public void childLayoutCenter() {
    childLayout(ChildLayoutType.Center);
  }

  public void childLayoutAbsolute() {
    childLayout(ChildLayoutType.Absolute);
  }

  public void childLayoutOverlay() {
    childLayout(ChildLayoutType.Overlay);
  }

  public void height(@Nonnull final String height) {
    attributes.setHeight(height);
  }

  public void width(@Nonnull final String width) {
    attributes.setWidth(width);
  }

  public void x(@Nonnull final String x) {
    attributes.setX(x);
  }

  public void y(@Nonnull final String y) {
    attributes.setY(y);
  }

  public void childClip(final boolean childClip) {
    attributes.setChildClip(String.valueOf(childClip));
  }

  public void renderOrder(final int renderOrder) {
    attributes.setRenderOrder(renderOrder);
  }

  public void visible(final boolean visible) {
    attributes.setVisible(String.valueOf(visible));
  }

  public void focusable(final boolean focusable) {
    attributes.setFocusable(String.valueOf(focusable));
  }

  public void textHAlign(@Nonnull final Align align) {
    attributes.set("textHAlign", align.getLayout());
  }

  public void textHAlignLeft() {
    textHAlign(Align.Left);
  }

  public void textHAlignRight() {
    textHAlign(Align.Right);
  }

  public void textHAlignCenter() {
    textHAlign(Align.Center);
  }

  public void textVAlign(@Nonnull final VAlign valign) {
    attributes.set("textVAlign", valign.getLayout());
  }

  public void textVAlignTop() {
    textVAlign(VAlign.Top);
  }

  public void textVAlignBottom() {
    textVAlign(VAlign.Bottom);
  }

  public void textVAlignCenter() {
    textVAlign(VAlign.Center);
  }

  public void align(@Nonnull final Align align) {
    attributes.setAlign(align.getLayout());
  }

  public void alignLeft() {
    align(Align.Left);
  }

  public void alignRight() {
    align(Align.Right);
  }

  public void alignCenter() {
    align(Align.Center);
  }

  public void valign(@Nonnull final VAlign valign) {
    attributes.setVAlign(valign.getLayout());
  }

  public void valignTop() {
    valign(VAlign.Top);
  }

  public void valignBottom() {
    valign(VAlign.Bottom);
  }

  public void valignCenter() {
    valign(VAlign.Center);
  }

  public void visibleToMouse(final boolean visibleToMouse) {
    attributes.setVisibleToMouse(String.valueOf(visibleToMouse));
  }

  public void visibleToMouse() {
    visibleToMouse(true);
  }

  public void invisibleToMouse() {
    visibleToMouse(false);
  }

  public void font(@Nonnull final String font) {
    attributes.setFont(font);
  }

  public void filename(@Nonnull final String filename) {
    attributes.setFilename(filename);
  }

  public void padding(@Nonnull final String padding) {
    attributes.setPadding(padding);
  }

  public void paddingLeft(@Nonnull final String padding) {
    attributes.setPaddingLeft(padding);
  }

  public void paddingRight(@Nonnull final String padding) {
    attributes.setPaddingRight(padding);
  }

  public void paddingTop(@Nonnull final String padding) {
    attributes.setPaddingTop(padding);
  }

  public void paddingBottom(@Nonnull final String padding) {
    attributes.setPaddingBottom(padding);
  }

  public void margin(@Nonnull final String margin) {
    attributes.setMargin(margin);
  }

  public void marginLeft(@Nonnull final String margin) {
    attributes.setMarginLeft(margin);
  }

  public void marginRight(@Nonnull final String margin) {
    attributes.setMarginRight(margin);
  }

  public void marginTop(@Nonnull final String margin) {
    attributes.setMarginTop(margin);
  }

  public void marginBottom(@Nonnull final String margin) {
    attributes.setMarginBottom(margin);
  }

  public void set(@Nonnull final String key, @Nonnull final String value) {
    attributes.set(key, value);
  }

  public void onStartScreenEffect(final EffectBuilder onStartScreenEffect) {
    onStartScreen.add(onStartScreenEffect);
  }

  public void onEndScreenEffect(final EffectBuilder onEndScreenEffect) {
    onEndScreen.add(onEndScreenEffect);
  }

  public void onHoverEffect(final HoverEffectBuilder onHoverEffect) {
    onHover.add(onHoverEffect);
  }

  public void onStartHoverEffect(final HoverEffectBuilder onStartHoverEffect) {
    onStartHover.add(onStartHoverEffect);
  }

  public void onEndHoverEffect(final HoverEffectBuilder onEndHoverEffect) {
    onEndHover.add(onEndHoverEffect);
  }

  public void onClickEffect(final EffectBuilder onClickEffect) {
    onClick.add(onClickEffect);
  }

  public void onFocusEffect(final EffectBuilder onFocusEffect) {
    onFocus.add(onFocusEffect);
  }

  public void onLostFocusEffect(final EffectBuilder onLostFocusEffect) {
    onLostFocus.add(onLostFocusEffect);
  }

  public void onGetFocusEffect(final EffectBuilder onGetFocusEffect) {
    onGetFocus.add(onGetFocusEffect);
  }

  public void onActiveEffect(final EffectBuilder onActiveEffect) {
    onActive.add(onActiveEffect);
  }

  public void onShowEffect(final EffectBuilder onShowEffect) {
    onShow.add(onShowEffect);
  }

  public void onHideEffect(final EffectBuilder onHideEffect) {
    onHide.add(onHideEffect);
  }

  public void onCustomEffect(final EffectBuilder onCustomEffect) {
    onCustom.add(onCustomEffect);
  }

  public void interactOnClick(@Nonnull String method) {
    attributes.setInteractOnClick(method);
  }

  public void interactOnRelease(@Nonnull final String onRelease) {
    attributes.setInteractOnRelease(onRelease);
  }

  public void interactOnMouseOver(@Nonnull final String onMouseOver) {
    attributes.setInteractOnMouseOver(onMouseOver);
  }

  public void interactOnClickRepeat(@Nonnull final String onClickRepeat) {
    attributes.setInteractOnClickRepeat(onClickRepeat);
  }

  public void interactOnClickMouseMove(@Nonnull final String onClickMouseMove) {
    attributes.setInteractOnClickMouseMove(onClickMouseMove);
  }

  public void interactOnClickAlternateKey(@Nonnull final String onClickAlternateKey) {
    attributes.setInteractOnClickAlternateKey(onClickAlternateKey);
  }

  @Nonnull
  public String percentage(final int percentage) {
    return Integer.toString(percentage) + "%";
  }

  @Nonnull
  public String pixels(final int px) {
    return Integer.toString(px) + "px";
  }

  private void connectAttributes() {
    attributes.setEffects(createEffects());
    for (EffectBuilder effectBuild : onStartScreen) {
      attributes.addEffectsOnStartScreen(effectBuild.getAttributes());
    }
    for (EffectBuilder effectBuild : onEndScreen) {
      attributes.addEffectsOnEndScreen(effectBuild.getAttributes());
    }
    for (HoverEffectBuilder effectBuild : onHover) {
      attributes.addEffectsOnHover(effectBuild.getAttributes());
    }
    for (HoverEffectBuilder effectBuild : onStartHover) {
      attributes.addEffectsOnStartHover(effectBuild.getAttributes());
    }
    for (HoverEffectBuilder effectBuild : onEndHover) {
      attributes.addEffectsOnEndHover(effectBuild.getAttributes());
    }
    for (EffectBuilder effectBuild : onClick) {
      attributes.addEffectsOnClick(effectBuild.getAttributes());
    }
    for (EffectBuilder effectBuild : onFocus) {
      attributes.addEffectsOnFocus(effectBuild.getAttributes());
    }
    for (EffectBuilder effectBuild : onLostFocus) {
      attributes.addEffectsOnLostFocus(effectBuild.getAttributes());
    }
    for (EffectBuilder effectBuild : onGetFocus) {
      attributes.addEffectsOnGetFocus(effectBuild.getAttributes());
    }
    for (EffectBuilder effectBuild : onActive) {
      attributes.addEffectsOnActive(effectBuild.getAttributes());
    }
    for (EffectBuilder effectBuild : onCustom) {
      attributes.addEffectsOnCustom(effectBuild.getAttributes());
    }
    for (EffectBuilder effectBuild : onShow) {
      attributes.addEffectsOnShow(effectBuild.getAttributes());
    }
    for (EffectBuilder effectBuild : onHide) {
      attributes.addEffectsOnHide(effectBuild.getAttributes());
    }
  }

  @Nonnull
  private ControlEffectsAttributes createEffects() {
    return new ControlEffectsAttributes();
  }

  public void build(@Nonnull final Nifty nifty) {
    connectAttributes();

    StyleType style = attributes.createStyleType(styleAttributes);
    nifty.registerStyle(style);
  }
}
