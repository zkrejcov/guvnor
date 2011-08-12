/*
 * Copyright 2011 JBoss Inc
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.drools.guvnor.client.explorer;

import java.util.ArrayList;
import java.util.Collection;

import org.drools.guvnor.client.explorer.navigation.NavigationItemBuilder;
import org.drools.guvnor.client.explorer.navigation.admin.AdminTreeBuilder;
import org.drools.guvnor.client.explorer.navigation.browse.BrowseTreeBuilder;
import org.drools.guvnor.client.explorer.navigation.deployment.DeploymentTreeBuilder;
import org.drools.guvnor.client.explorer.navigation.modules.KnowledgeModulesTreeBuilder;
import org.drools.guvnor.client.explorer.navigation.qa.QATreeBuilder;

public class AuthorPerspective extends Perspective {

    public Collection<NavigationItemBuilder> getBuilders(ClientFactory clientFactory) {

        Collection<NavigationItemBuilder> navigationItemBuilders = new ArrayList<NavigationItemBuilder>();

        navigationItemBuilders.add(new BrowseTreeBuilder(clientFactory));

        navigationItemBuilders.add(new KnowledgeModulesTreeBuilder(clientFactory));

        navigationItemBuilders.add(new QATreeBuilder(clientFactory));

        navigationItemBuilders.add(new DeploymentTreeBuilder(clientFactory));

        navigationItemBuilders.add(new AdminTreeBuilder(clientFactory));

        return navigationItemBuilders;
    }
}
