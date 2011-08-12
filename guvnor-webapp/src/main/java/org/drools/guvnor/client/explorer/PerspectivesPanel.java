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

import java.util.HashMap;
import java.util.Map;

import org.drools.guvnor.client.explorer.PerspectivesPanelView.Presenter;
import org.drools.guvnor.client.util.TabbedPanel;

public class PerspectivesPanel implements Presenter {

    private final PerspectivesPanelView view;
    private final ClientFactory clientFactory;

    private final Map<String, Perspective> perspectives = new HashMap<String, Perspective>();

    public PerspectivesPanel(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        this.view = clientFactory.getPerspectivesPanelView();
        this.view.setPresenter(this);
        setPerspective(new AuthorPerspective());
        view.addAuthorPerspective();
        view.addRunTimePerspective();
    }

    private void setPerspective(Perspective perspective) {
        clientFactory.getEventBus().fireEvent(new ChangePerspectiveEvent(perspective));
    }

    public PerspectivesPanelView getView() {
        return view;
    }

    public void setUserName(String userName) {
        view.setUserName(userName);
    }

    public void onChangePerspectiveToAuthor() {
        setPerspective(new AuthorPerspective());
    }

    public void onChangePerspectiveToRunTime() {
        setPerspective(new RunTimePerspective());
    }

    public TabbedPanel getTabbedPanel() {
        return view.getTabbedPanel();
    }

}
