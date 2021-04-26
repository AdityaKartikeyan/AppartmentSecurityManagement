import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListAllVisitorsComponent from './components/ListAllVisitorsComponent';
import CreateVisitorComponent from './components/CreateVisitorComponent';
import UpdateVisitorComponent from './components/UpdateVisitorComponent';
import ViewVisitorComponent from './components/ViewVisitorComponent';
import BaseEntity from './components/BaseEntity';

function App() {
  return (
    <div>
      <Router>
          <HeaderComponent/>
            <div className="container">
              <Switch>  
                <Route path = "/" exact component = {ListAllVisitorsComponent}></Route>
                <Route path = "/visitors" component = {ListAllVisitorsComponent}></Route>
                <Route path = "/addVisitor" component = {CreateVisitorComponent}></Route>
                <Route path = "/updateVisitor/:visitorId" component = {UpdateVisitorComponent}></Route>
                <Route path = "/getById/:visitorId" component = {ViewVisitorComponent}></Route>
                <Route path = "/getByPk/:visitorId" component={BaseEntity}></Route>
              </Switch>
            </div>
          <FooterComponent/>
      </Router>
    </div>
  );
}

export default App;
