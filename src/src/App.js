
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import FooterComponent from './Components/FooterComponent';
import HeaderComponent from './Components/HeaderComponent';
import ListFlatComponent from './Components/ListFlatComponent';
import CreateFlatComponent from './Components/CreateFlatComponent';
import UpdateFlatComponent from './Components/UpdateFlatComponent';
import ViewFlatComponent from './Components/ViewFlatComponent';
import BaseEntity from './Components/BaseEntity';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Switch>
            <Route
              path="/"
              exact
              component={ListFlatComponent}
            ></Route>
            <Route
              path="/flat"
              component={ListFlatComponent}
            ></Route>
            <Route
              path="/addFlat"
              component={CreateFlatComponent}
            ></Route>
            <Route
              path="/updateFlat/:flatNo"
              component={UpdateFlatComponent}
            ></Route>
            <Route
              path="/getById/:flatNo"
              component={ViewFlatComponent}
            ></Route>
            
            <Route path="/getByPk/:flatNo" component={BaseEntity}></Route>
          </Switch>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
