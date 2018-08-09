package com.epam.andrei_sterkhov.online_shop.repository.impl;

import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.ItemIntoBasket;
import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.repository.ItemIntoBasketRepository;
import com.epam.andrei_sterkhov.online_shop.service.ItemService;
import com.epam.andrei_sterkhov.online_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ItemIntoBasketRepositoryImpl implements ItemIntoBasketRepository {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    //final RowMapper<ItemIntoBasket> rowMapper = new BeanPropertyRowMapper<>(ItemIntoBasket.class);

    @Override
    public ItemIntoBasket findBasketByUserAndItem(User user, Item item) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForObject("Select * From basket Where user_id = ? and item_id = ?",
                new Object[]{user.getId(), item.getId()}, new BeanPropertyRowMapper<ItemIntoBasket>() {
                    @Override
                    public ItemIntoBasket mapRow(ResultSet rs, int rowNumber) throws SQLException {
                        ItemIntoBasket itemIntoBasket = new ItemIntoBasket();
                        itemIntoBasket.setId(rs.getLong("id"));

                        Optional<User> optionalUser = userService.getUserById(rs.getLong("user_id"));
                        optionalUser.ifPresent(itemIntoBasket::setUser);

                        Optional<Item> optionalItem = itemService.getItemById(rs.getLong("item_id"));
                        optionalItem.ifPresent(itemIntoBasket::setItem);

                        itemIntoBasket.setAmount(rs.getInt("amount"));
                        return itemIntoBasket;
                    }
                });
    }

    @Override
    public Optional<BigInteger> getItemCount(Long userId) {
        return Optional.empty();
    }

    @Override
    public List<ItemIntoBasket> findAllByUserId(Long userId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query("Select * From basket Where user_id = ?", new Object[]{userId}, new BeanPropertyRowMapper<ItemIntoBasket>() {
            @Override
            public ItemIntoBasket mapRow(ResultSet rs, int rowNumber) throws SQLException {
                ItemIntoBasket itemIntoBasket = new ItemIntoBasket();
                itemIntoBasket.setId(rs.getLong("id"));

                Optional<User> optionalUser = userService.getUserById(rs.getLong("user_id"));
                optionalUser.ifPresent(itemIntoBasket::setUser);

                Optional<Item> optionalItem = itemService.getItemById(rs.getLong("item_id"));
                optionalItem.ifPresent(itemIntoBasket::setItem);

                itemIntoBasket.setAmount(rs.getInt("amount"));
                return itemIntoBasket;
            }
        });
    }

    @Override
    public long createItemIntoBasket(ItemIntoBasket itemIntoBasket) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("user_id", itemIntoBasket.getUser().getId())
                .addValue("item_id", itemIntoBasket.getItem().getId())
                .addValue("amount", itemIntoBasket.getAmount());
        namedParameterJdbcTemplate.update("Insert into basket (user_id, item_id, amount) Values" +
                "(:user_id, :item_id, :amount)", sqlParameterSource, keyHolder);
        return (long) keyHolder.getKeys().get("id");
    }

    @Override
    public ItemIntoBasket getById(Long id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForObject("Select * From basket Where id = ?", new Object[]{id}, new BeanPropertyRowMapper<ItemIntoBasket>() {
            @Override
            public ItemIntoBasket mapRow(ResultSet rs, int rowNumber) throws SQLException {
                ItemIntoBasket itemIntoBasket = new ItemIntoBasket();
                itemIntoBasket.setId(rs.getLong("id"));

                Optional<User> optionalUser = userService.getUserById(rs.getLong("user_id"));
                optionalUser.ifPresent(itemIntoBasket::setUser);

                Optional<Item> optionalItem = itemService.getItemById(rs.getLong("item_id"));
                optionalItem.ifPresent(itemIntoBasket::setItem);

                itemIntoBasket.setAmount(rs.getInt("amount"));
                return itemIntoBasket;
            }
        });
    }

    @Override
    public void deleteById(Long id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("Delete from basket Where id = ?", id);
    }

    @Override
    public void increaseAmountOfItem(ItemIntoBasket itemIntoBasket) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("Update basket Set amount = ? Where id = ?",
                itemIntoBasket.getAmount(), itemIntoBasket.getId());
    }
}
