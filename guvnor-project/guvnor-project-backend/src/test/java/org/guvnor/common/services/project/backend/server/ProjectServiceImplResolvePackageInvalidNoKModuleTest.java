/*
 * Copyright 2013 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.guvnor.common.services.project.backend.server;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.net.URL;

import org.guvnor.common.services.project.model.Package;
import org.guvnor.common.services.project.service.ProjectService;
import org.junit.Test;
import org.uberfire.backend.vfs.Path;

public class ProjectServiceImplResolvePackageInvalidNoKModuleTest extends ProjectServiceImplBaseTest {

    @Test
    public void testProjectServiceInstantiation() throws Exception {
        final ProjectService projectService = getService(ProjectService.class);
        assertNotNull( projectService );
    }

    @Test
    public void testResolvePackageWithNonProjectPath() throws Exception {

        final ProjectService projectService = getService(ProjectService.class);

        final URL testUrl = this.getClass().getResource( "/" );
        final org.uberfire.java.nio.file.Path testNioPath = fs.getPath( testUrl.toURI() );
        final Path testPath = paths.convert( testNioPath );

        //Test a non-Project Path resolves to null
        final Package result = projectService.resolvePackage( testPath );
        assertNull( result );
    }

    @Test
    public void testResolvePackageWithRootPath() throws Exception {

        final ProjectService projectService = getService(ProjectService.class);


        final URL rootUrl = this.getClass().getResource("/ProjectBackendTestProjectStructureInvalidNoKModule");
        final org.uberfire.java.nio.file.Path nioRootPath = fs.getPath( rootUrl.toURI() );
        final Path rootPath = paths.convert( nioRootPath );

        //Test a non-Project Path resolves to null
        final Package result = projectService.resolvePackage( rootPath );
        assertNull( result );
    }

    @Test
    public void testResolvePackageWithSrcPath() throws Exception {

        final ProjectService projectService = getService(ProjectService.class);

        final URL rootUrl = this.getClass().getResource("/ProjectBackendTestProjectStructureInvalidNoKModule/src");
        final org.uberfire.java.nio.file.Path nioRootPath = fs.getPath( rootUrl.toURI() );
        final Path rootPath = paths.convert( nioRootPath );

        //Test a non-Project Path resolves to null
        final Package result = projectService.resolvePackage( rootPath );
        assertNull( result );
    }

    @Test
    public void testResolvePackageWithMainPath() throws Exception {

        final ProjectService projectService = getService(ProjectService.class);

        final URL rootUrl = this.getClass().getResource("/ProjectBackendTestProjectStructureInvalidNoKModule/src/main");
        final org.uberfire.java.nio.file.Path nioRootPath = fs.getPath( rootUrl.toURI() );
        final Path rootPath = paths.convert( nioRootPath );

        //Test a non-Project Path resolves to null
        final Package result = projectService.resolvePackage( rootPath );
        assertNull( result );
    }

    @Test
    public void testResolvePackageDefaultJava() throws Exception {

        final ProjectService projectService = getService(ProjectService.class);
        
        final URL rootUrl = this.getClass().getResource("/ProjectBackendTestProjectStructureInvalidNoKModule/src/main/java");
        final org.uberfire.java.nio.file.Path nioRootPath = fs.getPath( rootUrl.toURI() );
        final Path rootPath = paths.convert( nioRootPath );

        final URL testUrl = this.getClass().getResource("/ProjectBackendTestProjectStructureInvalidNoKModule/src/main/java");
        final org.uberfire.java.nio.file.Path nioTestPath = fs.getPath( testUrl.toURI() );
        final Path testPath = paths.convert( nioTestPath );

        //Test a non-Project Path resolves to null
        final Package result = projectService.resolvePackage( testPath );
        assertNull( result );
    }

    @Test
    public void testResolvePackageDefaultResources() throws Exception {

        final ProjectService projectService = getService(ProjectService.class);

        final URL rootUrl = this.getClass().getResource("/ProjectBackendTestProjectStructureInvalidNoKModule/src/main/resources");
        final org.uberfire.java.nio.file.Path nioRootPath = fs.getPath( rootUrl.toURI() );
        final Path rootPath = paths.convert( nioRootPath );

        final URL testUrl = this.getClass().getResource("/ProjectBackendTestProjectStructureInvalidNoKModule/src/main/resources");
        final org.uberfire.java.nio.file.Path nioTestPath = fs.getPath( testUrl.toURI() );
        final Path testPath = paths.convert( nioTestPath );

        //Test a non-Project Path resolves to null
        final Package result = projectService.resolvePackage( testPath );
        assertNull( result );
    }

    @Test
    public void testResolvePackageWithJavaFileInDefaultPackage() throws Exception {

        final ProjectService projectService = getService(ProjectService.class);

        final URL rootUrl = this.getClass().getResource("/ProjectBackendTestProjectStructureInvalidNoKModule/src/main/java");
        final org.uberfire.java.nio.file.Path nioRootPath = fs.getPath( rootUrl.toURI() );
        final Path rootPath = paths.convert( nioRootPath );

        final URL testUrl = this.getClass().getResource("/ProjectBackendTestProjectStructureInvalidNoKModule/src/main/java/Bean.java");
        final org.uberfire.java.nio.file.Path nioTestPath = fs.getPath( testUrl.toURI() );
        final Path testPath = paths.convert( nioTestPath );

        //Test a non-Project Path resolves to null
        final Package result = projectService.resolvePackage( testPath );
        assertNull( result );
    }

    @Test
    public void testResolvePackageWithJavaFileInSubPackage() throws Exception {

        final ProjectService projectService = getService(ProjectService.class);

        final URL rootUrl = this.getClass().getResource("/ProjectBackendTestProjectStructureInvalidNoKModule/src/main/java/org/kie/test");
        final org.uberfire.java.nio.file.Path nioRootPath = fs.getPath( rootUrl.toURI() );
        final Path rootPath = paths.convert( nioRootPath );

        final URL testUrl = this.getClass().getResource("/ProjectBackendTestProjectStructureInvalidNoKModule/src/main/java/org/kie/test/Bean.java");
        final org.uberfire.java.nio.file.Path nioTestPath = fs.getPath( testUrl.toURI() );
        final Path testPath = paths.convert( nioTestPath );

        //Test a non-Project Path resolves to null
        final Package result = projectService.resolvePackage( testPath );
        assertNull( result );
    }

    @Test
    public void testResolvePackageWithResourcesFileInDefaultPackage() throws Exception {

        final ProjectService projectService = getService(ProjectService.class);

        final URL rootUrl = this.getClass().getResource("/ProjectBackendTestProjectStructureInvalidNoKModule/src/main/resources");
        final org.uberfire.java.nio.file.Path nioRootPath = fs.getPath( rootUrl.toURI() );
        final Path rootPath = paths.convert( nioRootPath );

        final URL testUrl = this.getClass().getResource("/ProjectBackendTestProjectStructureInvalidNoKModule/src/main/resources/rule1.drl");
        final org.uberfire.java.nio.file.Path nioTestPath = fs.getPath( testUrl.toURI() );
        final Path testPath = paths.convert( nioTestPath );

        //Test a non-Project Path resolves to null
        final Package result = projectService.resolvePackage( testPath );
        assertNull( result );
    }

    @Test
    public void testResolvePackageWithResourcesFileInSubPackage() throws Exception {

        final ProjectService projectService = getService(ProjectService.class);

        final URL rootUrl = this.getClass().getResource("/ProjectBackendTestProjectStructureInvalidNoKModule/src/main/resources/org/kie/test");
        final org.uberfire.java.nio.file.Path nioRootPath = fs.getPath( rootUrl.toURI() );
        final Path rootPath = paths.convert( nioRootPath );

        final URL testUrl = this.getClass().getResource("/ProjectBackendTestProjectStructureInvalidNoKModule/src/main/resources/org/kie/test/rule1.drl");
        final org.uberfire.java.nio.file.Path nioTestPath = fs.getPath( testUrl.toURI() );
        final Path testPath = paths.convert( nioTestPath );

        //Test a non-Project Path resolves to null
        final Package result = projectService.resolvePackage( testPath );
        assertNull( result );
    }

}
