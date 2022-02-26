package net.focik.scopework.domain.scopegasconnection;

import net.focik.scopework.share.TaskType;
import net.focik.scopework.scopegasconnection.domain.ScopeGasConnection;
import net.focik.scopework.scopegasconnection.domain.ScopeGasConnectionFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScopeGasConnectionFacadeTest {

    @Autowired
    ScopeGasConnectionFacade facade;

    @Test
    void should_return_list_size_2() {
        //given
        final int ID = 1;
        final TaskType TASK_TYPE = TaskType.GAS_CONNECTION;

        //when
        List<ScopeGasConnection> result = facade.getScopeGasConnectionList(ID, TASK_TYPE);

        //then
        assertEquals(2,result.size());

    }
}