import React, { Component } from "react";
import GuardTrainingService from "../services/GuardTrainingService";

class ViewGuardComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      userId: this.props.match.params.userId,
      guardTraining: {},
    };
  }

  componentDidMount() {
    GuardTrainingService.getGuardTrainingByUserId(this.state.userId).then(
      (res) => {
        this.setState({ guardTraining: res.data });
      }
    );
  }
  render() {
    return (
      <div>
        <br></br>
        <div className="card col-md-6 offset-md-3">
          <h3 className="text-center"> View Guard Training Details</h3>
          <div className="card-body">
            <div className="row">
              <label> Guard Name: </label>
              <div> {this.state.guardTraining.name}</div>
            </div>
            <div className="row">
              <label> Guard Mobile No: </label>
              <div> {this.state.guardTraining.mobileNo}</div>
            </div>
            <div className="row">
              <label> Guard Status: </label>
              <div> {this.state.guardTraining.status}</div>
            </div>
            <div className="row">
              <label> Guard Timing: </label>
              <div> {this.state.guardTraining.timing}</div>
            </div>
            <div className="row">
              <label> Date: </label>
              <div> {this.state.guardTraining.date}</div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default ViewGuardComponent;
