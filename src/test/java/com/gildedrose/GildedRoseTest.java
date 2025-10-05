package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    String agedBrie = "Aged Brie";
    String sulfuras = "Sulfuras, Hand of Ragnaros";
    String backstagePasses = "Backstage passes to a TAFKAL80ETC concert";
    String conjured = "Conjured";

    @Test
    void qualityDecreaseDaily() {
        Item[] items = new Item[]{new Item("Cheese", 4, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void qualityDecreaseTwiceAsFast() {
        Item[] items = new Item[]{new Item("Cheese", 0, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityNoDecreaseAfterZero() {
        Item[] items = new Item[]{new Item("Cheese", 4, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityIncreaseIfAgedBrie() {
        Item[] items = new Item[]{new Item(agedBrie, 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void qualityNoIncreaseAfterFifty() {
        Item[] items = new Item[]{new Item(agedBrie, 1, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void qualityAndSellInRemainsIfSulfuras() {
        Item[] items = new Item[]{new Item(sulfuras, 5, 80),
                new Item(sulfuras, 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }

    @Test
    void qualityIncreaseIfBackstagePasses() {
        Item[] items = new Item[]{new Item(backstagePasses, 6, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, app.items[0].quality);
        app.updateQuality();
        assertEquals(35, app.items[0].quality);
    }

    @Test
    void qualityDropsToZeroIfBackstagePassesAndLastDay() {
        Item[] items = new Item[]{new Item(backstagePasses, 0, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityDecreaseTwiceAsFastIfConjured() {
        Item[] items = new Item[]{new Item(conjured, 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

}
