package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);

    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
  }

  @Test
  @DisplayName("Test toString")
  void testToString() {
    Item element = new Item("foo", 0, 0);

    GildedRose app = new GildedRose(new Item[] {element});
    app.toString();
    assertThat(element.toString(), is("foo, 0, 0"));
  }


  @Test
  @DisplayName("Test that the quality of the elements is between 0 and 50")
  void testQuSe() {
    Item element = new Item("foo", 3, 5);
    Item element1 = new Item("foo", -1, 5);

    GildedRose app = new GildedRose(new Item[] {element, element1});
    app.updateQuality();
    assertThat(element.sellIn, is(2));
    assertThat(element.quality, is(4));

    assertThat(element1.sellIn, is(-2));
    assertThat(element1.quality, is(3));
  }

  @Test
  @DisplayName("Test that the quality and sellin of 'Sulfuras' is unchanged")
  void testSulfuras() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 4, 80);
    Item element1 = new Item("Sulfuras, Hand of Ragnaros", -1, 80);

    GildedRose app = new GildedRose(new Item[] {element, element1});
    app.updateQuality();
    assertThat(element.sellIn, is(4));
    assertThat(element.quality, is(80));

    assertThat(element1.sellIn, is(-1));
    assertThat(element1.quality, is(80));
  }

  @Test
  @DisplayName("Test the quality and sellin of 'elexir'")
  void testElexire() {
    Item element = new Item("Elixir of the Mongoose", 5, 30);
    Item element1 = new Item("Elixir of the Mongoose", -1, 30);

    GildedRose app = new GildedRose(new Item[] {element, element1});
    app.updateQuality();
    assertThat(element.sellIn, is(4));
    assertThat(element.quality, is(29));

    assertThat(element1.sellIn, is(-2));
    assertThat(element1.quality, is(28));
  }

  @Test
  @DisplayName("Test the quality and sellin of 'mana cake'")
  void testMana() {
    Item element = new Item("Conjured Mana Cake", 5, 30);
    Item element1 = new Item("Conjured Mana Cake", -1, 30);

    GildedRose app = new GildedRose(new Item[] {element, element1});
    app.updateQuality();
    assertThat(element.sellIn, is(4));
    assertThat(element.quality, is(28));

    assertThat(element1.quality, is(26));
  }

  @Test
  @DisplayName("Tests on the 'Aged Brie'")
  void testAgedBrie() {
    Item element = new Item("Aged Brie", 30, 10);
    Item element1 = new Item("Aged Brie", 9, 20);
    Item element2 = new Item("Aged Brie", 5, 30);
    Item element3 = new Item("Aged Brie", 1, 2);

    Item element4 = new Item("Aged Brie", 9, 50);

    Item element5 = new Item("Aged Brie", -1, 2);
    Item element6 = new Item("Aged Brie", -1, 49);

    GildedRose app = new GildedRose(new Item[] {element, element1, element2, element3, element4, element5, element6});
    app.updateQuality();
    assertThat(element.quality, is(11));
    assertThat(element.sellIn, is(29));

    assertThat(element1.quality, is(21));
    assertThat(element1.sellIn, is(8));

    assertThat(element2.quality, is(31));
    assertThat(element2.sellIn, is(4));

    assertThat(element3.quality, is(3));
    assertThat(element3.sellIn, is(0));

    assertThat(element4.quality, is(50));
    assertThat(element4.sellIn, is(8));

    assertThat(element5.quality, is(4));
    assertThat(element5.sellIn, is(-2));

    assertThat(element6.quality, is(50));
    assertThat(element6.sellIn, is(-2));
  }


  @Test
  @DisplayName("Tests on the 'Backstage passes'")
  void testBack() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 30, 10);
    Item element1 = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20);
    Item element2 = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30);
    Item element3 = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0);

    Item element4 = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 49);
    Item element5 = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);

    GildedRose app = new GildedRose(new Item[] {element, element1, element2, element3, element4, element5});
    app.updateQuality();
    assertThat(element.quality, is(11));
    assertThat(element.sellIn, is(29));

    assertThat(element1.quality, is(22));
    assertThat(element1.sellIn, is(8));

    assertThat(element2.quality, is(33));
    assertThat(element2.sellIn, is(4));

    assertThat(element3.quality, is(0));
    assertThat(element3.sellIn, is(-1));

    assertThat(element4.quality, is(50));
    assertThat(element4.sellIn, is(8));

    assertThat(element5.quality, is(50));
    assertThat(element5.sellIn, is(4));
  }

  @Test
  @DisplayName("Test quality  > 0")
  void testQuali() {
    Item element = new Item("foo", 0, 0);

    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(-1));
    assertThat(element.quality, is(0));
  }

}

// ./gradlew pitest