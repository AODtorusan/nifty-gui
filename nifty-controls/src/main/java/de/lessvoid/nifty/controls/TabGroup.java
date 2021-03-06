/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lessvoid.nifty.controls;

import de.lessvoid.nifty.EndNotify;
import de.lessvoid.nifty.controls.tabs.builder.TabBuilder;
import de.lessvoid.nifty.elements.Element;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A tab group is the parent element to a set of tabs. It allows selecting exactly one of those tabs for displaying.
 *
 * @author ractoc
 * @author Martin Karing &lt;nitram@illarion.org&gt;
 */
public interface TabGroup extends NiftyControl {
  /**
   * Adds a single tab to the end of the tab list. Its best if the element this tab belongs to is already a child of the
   * tab group. But if this is not the case, the tab will be moved to the proper spot.
   *
   * @param tab the tab that is supposed to be added to the tab group
   */
  void addTab(@Nonnull Tab tab);

  /**
   * Adds a single tab to the end of the tab list. Its best if the element this tab belongs to is already a child of the
   * tab group. But if this is not the case, the tab will be moved to the proper spot.
   *
   * @param tab the tab that is supposed to be added to the tab group
   * @throws IllegalArgumentException in case the {@code tab} does not contain a {@link Tab} as registered control
   */
  void addTab(@Nonnull Element tab);

  /**
   * Add a tab builder to the list.
   * <p/>
   * This is the best way to add new tabs as this method ensures that the newly created tab is located correctly as
   * child of this tab group and then added. This function automatically triggers the execution of the {@link
   * TabBuilder#build(de.lessvoid.nifty.Nifty, de.lessvoid.nifty.screen.Screen, Element)} function.
   *
   * @param tabBuilder the builder that is going to construct the tab that will be added to this tab group
   */
  void addTab(@Nonnull TabBuilder tabBuilder);

  /**
   * Get the tab that is currently selected.
   *
   * @return the tab that is currently active or {@code null} in case there are no tabs in this tab group
   */
  @Nullable
  Tab getSelectedTab();

  /**
   * Get the index of the tab that is currently selected.
   *
   * @return the index of the tab that is currently selected or {@code -1} in case there are no tabs in this group
   */
  int getSelectedTabIndex();

  /**
   * Get the amount of tabs that are currently part of this tab group.
   *
   * @return the amount of tabs that are part of this tab group
   */
  int getTabCount();

  /**
   * Get the index of a specified tab.
   *
   * @param tab the tab to check
   * @return the index of this tab or {@code -1} in case the tab is not part of this group or {@code null}
   */
  int indexOf(@Nonnull Tab tab);

  /**
   * Check if a tab is part of this group.
   *
   * @param tab the tab to check
   * @return {@code true} in case the tab is registered to this group
   */
  boolean isTabInGroup(@Nonnull Tab tab);

  /**
   * Removes the tab at a specified list index.
   *
   * @param index the index of the tab that is supposed to be removed
   * @throws IndexOutOfBoundsException in case the {@code index} parameter is less then 0 or larger then {@link
   *                                   #getTabCount()}
   */
  void removeTab(int index);

  /**
   * Remove a tab from this tab group.
   *
   * @param tab the tab that is supposed to be removed
   * @throws IllegalArgumentException in case the tab that is supposed to be removed is not a part of this tab group
   */
  void removeTab(@Nonnull Tab tab);

  /**
   * Remove a tab from this tab group.
   *
   * @param tab the tab that is supposed to be removed
   * @throws IllegalArgumentException in case the tab that is supposed to be removed is not a part of this tab group or
   *                                  in case the {@code tab} does not contain a {@link Tab} as registered control
   */
  void removeTab(@Nonnull Element tab);

  /**
   * Removes the tab at a specified list index.
   *
   * @param index  the index of the tab that is supposed to be removed
   * @param notify the notification that is called once the tab is removed
   * @throws IndexOutOfBoundsException in case the {@code index} parameter is less then 0 or larger then {@link
   *                                   #getTabCount()}
   */
  void removeTab(int index, @Nullable EndNotify notify);

  /**
   * Remove a tab from this tab group.
   *
   * @param tab    the tab that is supposed to be removed
   * @param notify the notification that is called once the tab is removed
   * @throws IllegalArgumentException in case the tab that is supposed to be removed is not a part of this tab group
   */
  void removeTab(@Nonnull Tab tab, @Nullable EndNotify notify);

  /**
   * Remove a tab from this tab group.
   *
   * @param tab    the tab that is supposed to be removed
   * @param notify the notification that is called once the tab is removed
   * @throws IllegalArgumentException in case the tab that is supposed to be removed is not a part of this tab group or
   *                                  in case the {@code tab} does not contain a {@link Tab} as registered control
   */
  void removeTab(@Nonnull Element tab, @Nullable EndNotify notify);

  /**
   * Change the selected tab to a specified tab.
   *
   * @param tab the tab that is supposed to be displayed in the tab group
   * @throws IllegalArgumentException in case the tab that is supposed to be removed is not a part of this tab group
   */
  void setSelectedTab(@Nonnull Tab tab);

  /**
   * Change the selected tab to a index.
   *
   * @param index the index of the tab that is supposed to be displayed
   * @throws IndexOutOfBoundsException in case the {@code index} parameter is less then 0 or larger then {@link
   *                                   #getTabCount()}
   */
  void setSelectedTabIndex(int index);

  /**
   * Set the caption of a tab.
   *
   * @param index   the index of the tab that is supposed to get a new caption
   * @param caption the new caption of this tab
   * @throws IndexOutOfBoundsException in case the {@code index} parameter is less then 0 or larger then {@link
   *                                   #getTabCount()}
   */
  void setTabCaption(int index, @Nonnull String caption);

  /**
   * Set the caption of a tab.
   *
   * @param tab     the tab that is supposed to receive a new caption
   * @param caption the new caption of this tab
   * @throws IllegalArgumentException in case the tab that is supposed to be removed is not a part of this tab group
   */
  void setTabCaption(@Nonnull Tab tab, @Nonnull String caption);
}
