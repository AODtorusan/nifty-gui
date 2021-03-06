package de.lessvoid.nifty.html;

import de.lessvoid.nifty.builder.TextBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.classextension.EasyMock.*;
import static org.junit.Assert.assertEquals;

public class NiftyBuilderFactoryTextBuilderTest {
  private TextBuilder textBuilderMock;
  private NiftyBuilderFactory builderFactory;

  @Before
  public void before() {
    textBuilderMock = createMock(TextBuilder.class);

    builderFactory = new NiftyBuilderFactory() {
      @Override
      public TextBuilder createTextBuilder() {
        return textBuilderMock;
      }
    };
  }

  @After
  public void after() {
    verify(textBuilderMock);
  }

  @Test
  public void testCreateTextBuilderWithoutColor() {
    textBuilderMock.text("huhu");
    textBuilderMock.wrap(true);
    textBuilderMock.alignLeft();
    textBuilderMock.valignTop();
    textBuilderMock.textHAlignLeft();
    textBuilderMock.textVAlignTop();
    textBuilderMock.font("fontname");
    textBuilderMock.width("100%");
    replay(textBuilderMock);

    assertEquals(textBuilderMock, builderFactory.createTextBuilder("huhu", "fontname", null));
  }

  @Test
  public void testCreateTextBuilderWithoutColorWithNewLine() {
    textBuilderMock.text("huhu\ntest");
    textBuilderMock.wrap(true);
    textBuilderMock.alignLeft();
    textBuilderMock.valignTop();
    textBuilderMock.textHAlignLeft();
    textBuilderMock.textVAlignTop();
    textBuilderMock.font("fontname");
    textBuilderMock.width("100%");
    replay(textBuilderMock);

    assertEquals(textBuilderMock, builderFactory.createTextBuilder("huhu\ntest", "fontname", null));
  }
}
