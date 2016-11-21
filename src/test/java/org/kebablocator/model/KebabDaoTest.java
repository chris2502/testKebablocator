package org.kebablocator.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kebablocator.exception.NoKebabFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.LinkedList;
import java.util.List;
import static org.mockito.Mockito.when;

/**
 * Created by ebongue on 11/11/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = KebabDao)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class KebabDaoTest {
    @Autowired
    KebabDao kebabDao;

    @Test(expected = NoKebabFoundException.class)
    public void should_return_exception_if_no_kebab(){
        int id = 1;
        when(kebabDao.exists((long)id)).thenReturn(false);
        kebabDao.findById(id);
    }

    @Test
    public void should_valid_if_this_kebab_in_database(){
        int id = 1;
        when(kebabDao.exists((long)id)).thenReturn(true);
        kebabDao.findById(id);
    }

    @Test
    public void should_return_all_kebab(){
        List<Kebab> kebabList = new LinkedList<>();
        when(kebabDao.findAll()).thenReturn(kebabList);
    }
}
