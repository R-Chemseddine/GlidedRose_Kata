package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }
            switch (item.name) {
                case "Aged Brie":
                if (item.quality < 50) {
                    item.quality++;
                }
                 
                item.sellIn--;  
                
                if (item.sellIn < 0) {
                    if (item.quality < 50) {
                        item.quality++;
                    }
                }
                    break;
                
                case "Backstage passes to a TAFKAL80ETC concert":
                if (item.quality < 50) {
                    item.quality++;
                }
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality++;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality++;
                        }
                    }

                    item.sellIn--;

                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }

                    break;
                case "Sulfuras, Hand of Ragnaros":

                    break;
            
                default:
                if (item.quality > 0) {
                    item.quality--;
                }
                    item.sellIn--;

                    if (item.sellIn < 0) {
                        if (item.quality > 0) {
                            item.quality--;
                        }
                    }
                    break;
            }

        }
    }
}