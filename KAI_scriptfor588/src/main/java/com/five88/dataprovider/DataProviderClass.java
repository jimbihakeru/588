package com.five88.dataprovider;

import com.five88.utils.AppEnum;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class DataProviderClass {

    @DataProvider(name = "data-provider-keno-type")
    public static Object[][] dataProviderLogin() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{AppEnum.KenoType.QUICK_KENO_1});
        data.add(new Object[]{AppEnum.KenoType.QUICK_KENO_2});
        data.add(new Object[]{AppEnum.KenoType.MAX_KENO_1});
        data.add(new Object[]{AppEnum.KenoType.MAX_KENO_2});
        data.add(new Object[]{AppEnum.KenoType.XUAN});
        data.add(new Object[]{AppEnum.KenoType.HA});
        data.add(new Object[]{AppEnum.KenoType.THU});
        data.add(new Object[]{AppEnum.KenoType.DONG});

        Object[][] dataArr = new Object[data.size()][];
        return data.toArray(dataArr);
    }

    @DataProvider(name = "data-provider-browser-type")
    public static Object[][] dataProviderBrowser() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{AppEnum.DriverType.CHROME});
        data.add(new Object[]{AppEnum.DriverType.FIREFOX});

        Object[][] dataArr = new Object[data.size()][];
        return data.toArray(dataArr);
    }
}
