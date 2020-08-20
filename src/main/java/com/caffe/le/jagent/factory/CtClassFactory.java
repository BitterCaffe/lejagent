package com.caffe.le.jagent.factory;

import com.caffe.le.jagent.pojo.dto.ConfigInfoDTO;
import com.caffe.le.jagent.strategy.AbstractMethodStrategy;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 * @author Caffe
 * @date 2020/6/26
 * @description: TODO
 */
public class CtClassFactory {

    /**
     * @param configInfoDTO
     * @param ctClass
     * @return
     * @throws NotFoundException
     * @throws CannotCompileException
     */
    public static CtClass getCtClass(ConfigInfoDTO configInfoDTO, CtClass ctClass) throws NotFoundException,
            CannotCompileException {
        boolean flag = filterChain(configInfoDTO);
        if (flag) {
            System.out.println("get CtMethod null flag:" + flag);
            return null;
        }
        return doGetCtClass(configInfoDTO, ctClass);
    }


    /**
     * @param configInfoDTO
     * @param ctClass
     * @return
     * @throws NotFoundException
     * @throws CannotCompileException
     */
    private static CtClass doGetCtClass(ConfigInfoDTO configInfoDTO, CtClass ctClass) throws NotFoundException,
            CannotCompileException {
        AbstractMethodStrategy abstractMethodStrategy = StrategyFactory.getStrategy(configInfoDTO);
        return abstractMethodStrategy.getCtClass(configInfoDTO, ctClass);
    }

    /**
     * 模仿过滤链、哪里不满足就断开并返回值
     *
     * @param configInfoDTO
     * @return
     */
    private static boolean filterChain(ConfigInfoDTO configInfoDTO) {

        if (null == configInfoDTO) {
            return true;
        }
        if (null == configInfoDTO.getClassName()) {
            return true;
        }

        if (null == configInfoDTO.getMethodName()) {
            return true;
        }
        if (null == configInfoDTO.getAddType()) {
            return true;
        }
        return false;
    }
}
