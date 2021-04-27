package cc.niushuai.cleveronitor.util;

import cc.niushuai.cleveronitor.entity.Machine;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author niushuai
 * @date 2021/4/27 16:41:07
 */
public class Constants {

    public static final String SEARCH_MACHINE_PARAM_VALUE = "/machine/params/value/";
    public static final String SEARCH_MACHINE = "/machine/list";
    public static Set<Machine> MACHINE_SET = new HashSet<>();
    /**
     * 默认地址
     */
    public static String DEFAULT_URL_PREFIX = "http://localhost:5900";

    public static Long CURRENT_SELECT_ID = 0L;
}
