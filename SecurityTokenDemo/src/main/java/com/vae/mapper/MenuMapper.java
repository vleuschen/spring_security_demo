package com.vae.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vae.domain.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(Long userId);
}
