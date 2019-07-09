package com.ipd.jianghuzuche.common.view;

import com.google.gson.Gson;
import com.ipd.jianghuzuche.bean.ModifyVersionBean;
import com.ipd.jianghuzuche.utils.LogUtils;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.proxy.IUpdateParser;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/7/3.
 */
public class CustomUpdateParser implements IUpdateParser {
    @Override
    public UpdateEntity parseJson(String json) throws Exception {
        LogUtils.i("rmy", "json = " + json);
        ModifyVersionBean result = new Gson().fromJson(json, ModifyVersionBean.class);
        if (result != null) {
            return new UpdateEntity()
                    .setHasUpdate(result.getData().getVersionYes().getNews() == 1 ? false : true)
                    .setForce(result.getData().getVersionYes().getModify() == 1 ? true : false)
                    .setIsIgnorable(false)
                    .setVersionCode(result.getData().getVersionYes().getVersionId())
                    .setVersionName(result.getData().getVersionYes().getVersionNo())
                    .setUpdateContent(result.getData().getVersionYes().getIntro())
                    .setDownloadUrl("");
        }
        return null;
    }
}
