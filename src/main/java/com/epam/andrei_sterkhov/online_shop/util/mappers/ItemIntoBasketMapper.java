package com.epam.andrei_sterkhov.online_shop.util.mappers;

import com.epam.andrei_sterkhov.online_shop.dto.ItemIntoBasket;
import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.service.ItemService;
import com.epam.andrei_sterkhov.online_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ItemIntoBasketMapper implements RowMapper<ItemIntoBasket> {

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Override
    public ItemIntoBasket mapRow(ResultSet rs, int rowNums) throws SQLException {
        ItemIntoBasket itemIntoBasket = new ItemIntoBasket();
        itemIntoBasket.setId(rs.getLong("id"));

        Optional<User> optionalUser = userService.getUserById(rs.getLong("user_id"));
        optionalUser.ifPresent(itemIntoBasket::setUser);

        itemIntoBasket.setItem(itemService.getItemById(rs.getLong("item_id")));
        itemIntoBasket.setAmount(rs.getInt("amount"));
        return itemIntoBasket;
    }
}
