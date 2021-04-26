import React, { Component } from "react";
import VehicleService from "../services/VehicleService";

class BaseEntity extends Component {
  constructor(props) {
    super(props);

    this.state = {
      vehicleNo: this.props.match.params.vehicleNo,
      base: {},
    };
  }

  componentDidMount() {
    VehicleService.getVehiclesByVehicleNo(this.state.vehicleNo).then(
      (res) => {
        this.setState({ base: res.data });
      }
    );
  }
  render() {
    return (
      <div>
        <br></br>
        <div className="card col-md-6 offset-md-3">
          <h3 className="text-center"> View Auditing Details</h3>
          <div className="card-body">
            <div className="row">
              <label> Id: </label>
              <div> {this.state.base.id}</div>
            </div>
            <div className="row">
              <label> Created By: </label>
              <div> {this.state.base.createdBy}</div>
            </div>
            <div className="row">
              <label> Modified By: </label>
              <div> {this.state.base.modifiedBy}</div>
            </div>

            <div className="row">
              <label> Modified: </label>
              <div> {this.state.base.modifiedDateTime}</div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default BaseEntity;