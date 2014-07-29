/*
 * Copyright 2014 Florian Vogelpohl <floriantobias@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.hsosnabrueck.ecs.richwps.wpsmonitor.data.dataaccess.defaultimpl;

import de.hsosnabrueck.ecs.richwps.wpsmonitor.create.CreateException;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.data.dataaccess.Range;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.data.dataaccess.WpsDaoFactory;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.data.dataaccess.WpsDataAccess;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.data.dataaccess.WpsProcessDaoFactory;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.data.dataaccess.WpsProcessDataAccess;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.data.entity.WpsEntity;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.data.entity.WpsProcessEntity;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Florian Vogelpohl <floriantobias@gmail.com>
 */
public class WpsProcessDaoTest {

    private static Jpa jpa;
    private static WpsDaoFactory wpsFactory;
    private static WpsProcessDaoFactory wpsProcessFactory;

    private static final Integer GENERATE_COUNT = 5;

    @BeforeClass
    public static void setUpClass() {
        jpa = new Jpa("de.hsosnabrueck.ecs.richwps_WPSMonitorTEST_pu");
        jpa.open();

        wpsFactory = new WpsDaoFactory(new WpsDaoDefaultFactory(jpa));
        wpsProcessFactory = new WpsProcessDaoFactory(new WpsProcessDaoDefaultFactory(jpa));
    }

    @AfterClass
    public static void tearDownClass() {
        jpa.close();
    }
    private WpsDataAccess wpsDao;
    private WpsProcessDataAccess wpsProcessDao;
    private Long[] insertedIds;

    private String wpsIdentifier;
    private String processIdentifier;

    @Before
    public void setUp() {
        try {

            wpsDao = wpsFactory.create();
            wpsDao.setAutoCommit(false);

            wpsProcessDao = wpsProcessFactory.create();
            wpsProcessDao.setAutoCommit(false);

            insertedIds = new Long[GENERATE_COUNT];

            WpsEntity wps;
            try {
                wps = new WpsEntity(UUID.randomUUID().toString(), "http://" + UUID.randomUUID().toString());
                wpsDao.persist(wps);

                wpsIdentifier = wps.getIdentifier();

                for (int i = 0; i < GENERATE_COUNT; i++) {
                    WpsProcessEntity wpsProcess = new WpsProcessEntity(UUID.randomUUID().toString(), wps);
                    wpsProcessDao.persist(wpsProcess);

                    if (i % 2 == 0) {
                        processIdentifier = wpsProcess.getIdentifier();
                    }

                    insertedIds[i] = wpsProcess.getId();
                }
            } catch (MalformedURLException | URISyntaxException ex) {
                fail(ex.toString());
            }

        } catch (CreateException ex) {
            fail("Can't create DAO!");
        }
    }

    @After
    public void tearDown() {
        wpsDao.rollback();
        wpsProcessDao.rollback();
    }

    /**
     * Test of find method, of class WpsProcessDao.
     */
    @Test
    public void testFindByAutogeneratedId() {
        WpsProcessEntity find = wpsProcessDao.find(insertedIds[0]);

        Assert.assertTrue(find != null);
    }

    /**
     * Test of get method, of class WpsProcessDao.
     */
    @Test
    public void testGet() {
        Range r = new Range(null, GENERATE_COUNT);
        List<WpsProcessEntity> get = wpsProcessDao.get(r);

        Assert.assertTrue(get != null && get.size() == GENERATE_COUNT);
    }

    /**
     * Test of find method, of class WpsProcessDao.
     */
    @Test
    public void testFindByWpsAndProcessIdentifier() {
        WpsProcessEntity find = wpsProcessDao.find(wpsIdentifier, processIdentifier);

        Assert.assertTrue(find != null
                && find.getIdentifier()
                .equals(processIdentifier)
                && find.getWps().getIdentifier()
                .equals(wpsIdentifier)
        );
    }

    /**
     * Test of getAll method, of class WpsProcessDao.
     */
    @Test
    public void testGetAll() {
        List<WpsProcessEntity> all = wpsProcessDao.getAll(wpsIdentifier);

        Boolean isValid = true;

        for (WpsProcessEntity e : all) {
            isValid = isValid
                    && e.getWps()
                    .getIdentifier()
                    .equals(wpsIdentifier);
        }

        Assert.assertTrue(all != null && all.size() == GENERATE_COUNT && isValid);
    }

    /**
     * Test of deleteProcessesOfWps method, of class WpsProcessDao.
     */
    @Test
    public void testDeleteProcessesFromWps() {
        wpsProcessDao.deleteProcessesOfWps(wpsIdentifier);

        List<WpsProcessEntity> all = wpsProcessDao.getAll(wpsIdentifier);

        Assert.assertTrue(all.isEmpty());
    }

    /**
     * Test of find method, of class WpsProcessDao.
     */
    @Test
    public void testFind_String_String() {
        WpsProcessEntity findById = wpsProcessDao.find(insertedIds[0]);
        WpsProcessEntity findByStrings = wpsProcessDao.find(findById.getWps().getIdentifier(), findById.getIdentifier());

        Assert.assertTrue(findById.equals(findByStrings));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFind_String_String_firstParamNull() {
        wpsProcessDao.find(null, processIdentifier);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFind_String_String_secondParamNull() {
        wpsProcessDao.find(wpsIdentifier, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFind_String_String_allParamNull() {
        wpsProcessDao.find(null, null);
    }

    /**
     * Test of deleteProcessesOfWps method, of class WpsProcessDao.
     */
    @Test
    public void testDeleteProcessesOfWps() {
        WpsProcessEntity findById = wpsProcessDao.find(insertedIds[0]);
        wpsProcessDao.deleteProcessesOfWps(findById.getWps().getIdentifier());
        List<WpsProcessEntity> all = wpsProcessDao.getAll(findById.getWps().getIdentifier());

        Assert.assertTrue(all.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteProcessesOfWps_allParamNull() {
        wpsProcessDao.deleteProcessesOfWps(null);
    }

    /**
     * Test of remove method, of class WpsProcessDao.
     */
    @Test
    public void testRemove_String_String() {
        wpsProcessDao.remove(wpsIdentifier, processIdentifier);
        WpsProcessEntity findById = wpsProcessDao.find(wpsIdentifier, processIdentifier);

        Assert.assertTrue(findById == null);
    }

}
