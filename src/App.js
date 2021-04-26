import React from 'react';
import './App.css';
import FooterComponent from './Components/FooterComponent';
import HeaderComponent from './Components/HeaderComponent';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListVehicleComponent from './Components/ListVehicleComponent';
import CreateVehicleComponent from './Components/CreateVehicleComponent';
import UpdateVehicleComponent from './Components/UpdateVehicleComponent';
import ViewVehicleComponent from './Components/ViewVehicleComponent';
import BaseEntity from './Components/BaseEntity';

function App() {
  return (
    <div>

      <Router>
            <HeaderComponent/>
            <div className="container">
              <Switch>
                    <Route path = "/" exact component = {ListVehicleComponent}></Route>
                    <Route path = "/vehicle" component = {ListVehicleComponent}></Route>
                    <Route path = "/add-Vehicle" component= {CreateVehicleComponent}></Route>
                    <Route path = "/update-Vehicle/:vehicleNo" component= {UpdateVehicleComponent}></Route>
                    <Route path = "/getById/:vehicleNo" component={ViewVehicleComponent}></Route>
                    <Route path="/getByPk/:vehicleNo" component={BaseEntity}></Route>
              </Switch>
            </div>
            <FooterComponent/>
      </Router>
    </div>
  );
}

export default App;
