package org.open.boot.dao.user;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.open.boot.BaseUnitTest;
import org.open.boot.dao.user.entity.UserDO;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author barnak
 */
public class UserManagerTest extends BaseUnitTest {

    @Resource
    private UserManager userManager;

    @Test
    public void test() {
        UserDO byId = userManager.getById(null);
    }

    @Test
    public void testUser() {
        UserDO byUserId = userManager.getByUserId("1");

    }

    public void test2() {
        UserDO userDO = userManager.selectByUserIds(1L);
    }

    @Test
    public void testParallelStream() {
        List<Long> userIdList = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        List<List<Long>> partition = Lists.partition(userIdList, 2);
        Map<Long,UserDO> userMap = new ConcurrentHashMap<>();
        partition.parallelStream().forEach(list -> {
            List<UserDO> userList = userManager.listByIds(list);
            userList.forEach(user -> {
                userMap.put(user.getId(), user);
            });
        });
        System.out.println(JSON.toJSONString(userMap));
    }

    @Test
    public void testFunction() {
        BiFunction<Integer, String, String> func = (k,v) -> String.join(",", Arrays.asList(String.valueOf(k), v));
        String s = doSomeThing(func);
        System.out.println(s);

        Map<Integer, String> userMap = new HashMap<>();
        String name = userMap.computeIfAbsent(1, k -> "路人甲");
        name = "路人乙";
        userMap.merge(1, name, (k, v) -> String.join(",", k, v));
        System.out.println(JSON.toJSONString(userMap));
    }

    public String doSomeThing(BiFunction<Integer, String, String> func) {
        return func.apply(1, "heihei");
    }
}