package com.caffe.le.jagent.factory;

import com.caffe.le.jagent.enums.AddTypeEnum;
import com.caffe.le.jagent.pojo.dto.ConfigInfoDTO;
import com.caffe.le.jagent.strategy.AbstractMethodStrategy;
import com.caffe.le.jagent.strategy.MethodStrategyAfter;
import com.caffe.le.jagent.strategy.MethodStrategyBefore;
import com.caffe.le.jagent.strategy.MethodStrategyBody;

/**
 * @author Caffe
 * @date 2020/6/26
 * @description: TODO
 */
public class StrategyFactory {
    /**
     * 策略工厂可以使用 注解+反射 来消除if 但是反射耗性能……
     *
     * @param configInfoDTO
     * @return
     */
    public static AbstractMethodStrategy getStrategy(ConfigInfoDTO configInfoDTO) {

        if (AddTypeEnum.BEFORE.getCode().equals(configInfoDTO.getAddType())) {
            return new MethodStrategyBefore();
        }

        if (AddTypeEnum.AFTER.getCode().equals(configInfoDTO.getAddType())) {
            return new MethodStrategyAfter();
        }

        if (AddTypeEnum.BODY.getCode().equals(configInfoDTO.getAddType())) {
            return new MethodStrategyBody();
        }

        return null;
    }
}
