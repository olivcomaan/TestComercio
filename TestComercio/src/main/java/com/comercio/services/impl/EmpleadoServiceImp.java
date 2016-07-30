package com.comercio.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comercio.services.EmpleadoService;


@Transactional(rollbackFor = { Exception.class })
@Service
public class EmpleadoServiceImp implements EmpleadoService{

}
