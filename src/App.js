import "./App.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import HeaderComponent from "./Components/HeaderComponent";
import FooterComponent from "./Components/FooterComponent";
import ListGuardShiftComponent from "./Components/ListGuardShiftComponent";
import CreateGuardShiftComponent from "./Components/CreateGuardShiftComponent";
import UpdateGuardShiftComponent from "./Components/UpdateGuardShiftComponent";
import ViewGuardComponent from "./Components/ViewGuardComponent";
import BaseEntity from "./Components/BaseEntity";


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
            component={ListGuardShiftComponent}
            ></Route>
            <Route
              path="/GuardShift"
              component={ListGuardShiftComponent}
            ></Route>
            <Route
              path="/add-GuardShift"
              component={CreateGuardShiftComponent}
            ></Route>
            <Route
              path="/update-GuardShift/:userId"
              component={UpdateGuardShiftComponent}
            ></Route>
            <Route
              path="/getById/:userId"
              component={ViewGuardComponent}
            ></Route>
          
            <Route path="/getByPk/:userId" component={BaseEntity}></Route>
           
          </Switch>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
