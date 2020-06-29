package com.agent.le.factory;

import com.agent.le.enums.AddTypeEnum;
import com.agent.le.pojo.dto.ConfigInfoDTO;
import com.agent.le.strategy.AbstractMethodStrategy;
import com.agent.le.strategy.MethodStrategyAfter;
import com.agent.le.strategy.MethodStrategyBefore;
import com.agent.le.strategy.MethodStrategyBody;

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
