package com.caffe.le.jagent.strategy;

import com.caffe.le.jagent.pojo.dto.ConfigInfoDTO;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 * @author Caffe
 * @date 2020/6/26
 * @description: TODO
 */
public abstract class AbstractMethodStrategy<T extends ConfigInfoDTO> {
    /**
     * @param t
     * @param ctClass
     * @return
     * @throws NotFoundException
     * @throws CannotCompileException
     */
    public abstract CtClass getCtClass(T t, CtClass ctClass) throws NotFoundException, CannotCompileException;

}
