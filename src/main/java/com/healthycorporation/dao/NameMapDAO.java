/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.dao;

import com.healthycorporation.entity.NameKeyValue;
import java.util.List;

/**
 *
 * @author wewezhu
 */
public interface NameMapDAO {
    public List<NameKeyValue> getNames();
}
