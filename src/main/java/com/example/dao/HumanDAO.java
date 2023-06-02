//package com.example.dao;
//
//import com.example.models.Book;
//import com.example.models.Human;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class HumanDAO {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public HumanDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Human> showAllHumans(){
//        return jdbcTemplate.query("select * from human", new HumanMapper());
//    }
//    public void addNewHuman(Human human){
//        jdbcTemplate.update("insert into human(name, birthday) values(?, ?)",
//                human.getName(), human.getBirthday());
//    }
//
//    public Human getCurrentHuman(String humanName){
//        return jdbcTemplate.query("select * from human where name=?", new Object[]{humanName},
//                     new BeanPropertyRowMapper<>(Human.class)).stream().findAny().orElse(null);
//    }
//    public Human getCurrentHuman(int id){
//        return showAllHumans().stream().filter(Human->Human.getId()==id).findAny().orElse(null);
//    }
//    public void patchHuman(int id, Human human){
//        jdbcTemplate.update("update human set name = ?, birthday = ? where id = ?", human.getName(),
//                human.getBirthday(), id);
//    }
//    public List<Book> showBooks(int id){
//        return jdbcTemplate.
//                query("select books.id, humanid, bookName, author, releaseDate from books " +
//                        "join human on books.humanid = human.id where human.id=?",
//                        new Object[]{id},
//                        new BookMapper());
//    }
//    public void deleteHuman(int id){
//            jdbcTemplate.update("delete from human where id=?",id);
//    }
//}
