package com.webkul.mobikul.mobikulstandalonepos.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.webkul.mobikul.mobikulstandalonepos.BR;
import com.webkul.mobikul.mobikulstandalonepos.R;
import com.webkul.mobikul.mobikulstandalonepos.db.converters.DataConverter;
import com.webkul.mobikul.mobikulstandalonepos.model.ProductCategoryModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman.gupta on 9/1/18.
 */

@Entity(tableName = "Product")
public class Product extends BaseObservable implements Serializable {
    @Ignore
    private Context context;

    public Product() {
    }

    public Product(Context context) {
        this.context = context;
    }

    @PrimaryKey(autoGenerate = true)
    private int pId;

    @ColumnInfo(name = "product_name")
    private String productName;

    @ColumnInfo(name = "product_s_deccription")
    private String productShortDes;

    @ColumnInfo(name = "sku")
    private String sku;

    @ColumnInfo(name = "is_enabled")
    private boolean isEnabled;

    @ColumnInfo(name = "price")
    private String price;

    @ColumnInfo(name = "formatted_price")
    private String formattedPrice;

    @ColumnInfo(name = "special_price")
    private String specialPrice;

    @ColumnInfo(name = "formatted_special_price")
    private String formattedSpecialPrice;

    @ColumnInfo(name = "is_taxable_goods_applied")
    private boolean isTaxableGoodsApplied;

    @ColumnInfo(name = "track_inventory")
    private boolean trackInventory;

    @ColumnInfo(name = "quantity")
    private String quantity;

    @ColumnInfo(name = "stock_availability")
    private boolean stock;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "weight")
    private String weight;

    @TypeConverters(DataConverter.class)
    @ColumnInfo(name = "productCategories")
    private List<ProductCategoryModel> productCategories;
    @Ignore
    private String cartQty;
    @Ignore
    private boolean displayError;

    public int getPId() {
        return pId;
    }

    public void setPId(int pId) {
        this.pId = pId;
    }

    @Bindable
    public String getProductName() {
        if (productName == null)
            return "";
        return productName;
    }

    @Bindable({"displayError", "productName"})
    public String getProductNameError() {
        if (!isDisplayError()) {
            return "";
        }
        if (getProductName().isEmpty()) {
            return "PRODUCT NAME IS EMPTY!";
        }
        return "";
    }

    public void setProductName(String productName) {
        this.productName = productName;
        notifyPropertyChanged(BR.productName);
    }

    public String getProductShortDes() {
        return productShortDes;
    }

    public void setProductShortDes(String productShortDes) {
        this.productShortDes = productShortDes;
    }

    @Bindable
    public String getSku() {
        if (sku == null)
            return "";
        return sku;
    }

    @Bindable({"displayError", "sku"})
    public String getSkuError() {
        if (!isDisplayError()) {
            return "";
        }
        if (getSku().isEmpty()) {
            return "SKU IS EMPTY!";
        }
        return "";
    }

    public void setSku(String sku) {
        this.sku = sku;
        notifyPropertyChanged(BR.sku);
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Bindable
    public String getPrice() {
        if (price == null)
            return "";
        return price;
    }

    @Bindable({"displayError", "price"})
    public String getPriceError() {
        if (!isDisplayError()) {
            return "";
        }
        String price = getPrice() + "";
        if (price.isEmpty()) {
            return "PRICE IS EMPTY!";
        }
        return "";
    }


    public void setPrice(String price) {
        this.price = price;
        if (context != null)
            setFormattedPrice(context.getString(R.string.currency_symbol) + price);
        notifyPropertyChanged(BR.price);
    }

    @Bindable
    public String getSpecialPrice() {
        if (specialPrice == null)
            return "";
        return specialPrice;
    }

    public void setSpecialPrice(String specialPrice) {
        if (context != null)
            setFormattedSpecialPrice(context.getString(R.string.currency_symbol) + specialPrice);
        this.specialPrice = specialPrice;
        notifyPropertyChanged(BR.specialPrice);
    }

    public boolean isTaxableGoodsApplied() {
        return isTaxableGoodsApplied;
    }

    public void setTaxableGoodsApplied(boolean taxableGoodsApplied) {
        isTaxableGoodsApplied = taxableGoodsApplied;
    }

    public boolean isTrackInventory() {
        return trackInventory;
    }

    public void setTrackInventory(boolean trackInventory) {
        this.trackInventory = trackInventory;
    }

    @Bindable
    public String getQuantity() {
        if (quantity == null)
            return "";
        return quantity;
    }

    @Bindable({"displayError", "quantity"})
    public String getQuantityError() {
        if (!isDisplayError()) {
            return "";
        }
        if (getQuantity().isEmpty()) {
            return "QUANTITY IS EMPTY!";
        }
        return "";
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
        notifyPropertyChanged(BR.quantity);
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    @Bindable

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
        notifyPropertyChanged(BR.image);
    }

    @Bindable
    public String getWeight() {
        if (weight == null)
            return "";
        return weight;
    }

    @Bindable({"displayError", "weight"})
    public String getWeightError() {
        if (!isDisplayError()) {
            return "";
        }
        if (getWeight().isEmpty()) {
            return "WEIGHT IS EMPTY!";
        }
        return "";
    }

    public void setWeight(String weight) {
        this.weight = weight;
        notifyPropertyChanged(BR.weight);
    }

    @Bindable
    public boolean isDisplayError() {
        return displayError;
    }

    public void setDisplayError(boolean displayError) {
        this.displayError = displayError;
        notifyPropertyChanged(BR.displayError);
    }

    public List<ProductCategoryModel> getProductCategories() {
        if (productCategories == null)
            return productCategories = new ArrayList<>();
        return productCategories;
    }

    public void setProductCategories(List<ProductCategoryModel> productCategories) {
        this.productCategories = productCategories;
    }

    @Bindable
    public String getCartQty() {
        if (cartQty == null)
            return "1";
        return cartQty;
    }

    public void setCartQty(String cartQty) {
        this.cartQty = cartQty;
        notifyPropertyChanged(BR.cartQty);
    }

    public String getFormattedPrice() {
        if (formattedPrice == null)
            return "";
        return formattedPrice;
    }

    public void setFormattedPrice(String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }

    public String getFormattedSpecialPrice() {
        if (formattedSpecialPrice == null)
            return "";
        return formattedSpecialPrice;
    }

    public void setFormattedSpecialPrice(String formattedSpecialPrice) {
        this.formattedSpecialPrice = formattedSpecialPrice;
    }
}