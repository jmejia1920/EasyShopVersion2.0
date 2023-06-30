package org.yearup.data.mysql;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.yearup.models.Category;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MySqlCategoryDaoTest extends BaseDaoTestClass
{
    private MySqlCategoryDao dao;

    @BeforeEach
    public void setup() {
        dao = new MySqlCategoryDao(dataSource);
    }



    @Test
    public void getById_shouldReturn_theCorrectCategory() {
        int categoryId = 1;

        Category expected = new Category() {{
            setCategoryId(1);
            setName("Electronics");
            setDescription("Explore the latest gadgets and electronic devices.");
        }};

        var actual = dao.getById(categoryId);

        assertEquals(expected.getCategoryId(), actual.getCategoryId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDescription(), actual.getDescription());

    }

    @Test
    public void getById2_shouldReturn_theCorrectCategory() {
        int categoryId = 2;

        Category expected = new Category() {{
            setCategoryId(2);
            setName("Fashion");
            setDescription("Discover trendy clothing and accessories for men and women.");
        }};

        var actual = dao.getById(categoryId);

        assertEquals(expected.getCategoryId(), actual.getCategoryId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDescription(), actual.getDescription());

    }

    @Test
    public void getAllCategories_shouldReturn_correctCategoryList() {
        // Arrange
        List<Category> expectedCategories = List.of(
                new Category(1, "Electronics", "Explore the latest gadgets and electronic devices."),
                new Category(2, "Fashion", "Discover trendy clothing and accessories for men and women."),
                new Category(3, "Home & Kitchen", "Find everything you need to decorate and equip your home.")
        );

        // Act
        Category category = new Category();
        List<Category> actualCategories = dao.getAllCategories();
        // Assert
        for (int i = 0; i < expectedCategories.size(); i++) {
            Category expectedCategory = expectedCategories.get(i);
            Category actualCategory = actualCategories.get(i);

            assertEquals(expectedCategory.getCategoryId(), actualCategory.getCategoryId());
            assertEquals(expectedCategory.getName(), actualCategory.getName());
            assertEquals(expectedCategory.getDescription(), actualCategory.getDescription());

        }
    }
}