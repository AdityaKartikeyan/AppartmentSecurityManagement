import React, { Component } from "react";
import GuardTrainingService from "../services/GuardTrainingService";

class ListGuardTrainingComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      guardTraining: [],
    };

    this.addGuardTraining = this.addGuardTraining.bind(this);
    this.editGuardTraining = this.editGuardTraining.bind(this);
    this.deleteGuardTraining = this.deleteGuardTraining.bind(this);
  }

  editGuardTraining(userId) {
    this.props.history.push(`/update-guardTraining/${userId}`);
  }
  componentDidMount() {
    GuardTrainingService.getGuardTraining().then((res) => {
      this.setState({ guardTraining: res.data });
    });
  }

  addGuardTraining() {
    this.props.history.push("/add-guardTraining");
  }

  viewGuardTraining(userId) {
    this.props.history.push(`/getById/${userId}`);
  }
  deleteGuardTraining(id) {
    GuardTrainingService.deleteGuardTraining(id).then((res) => {
      this.setState({
        guardTraining: this.state.guardTraining.filter(
          (guardTraining) => guardTraining.id !== id
        ),
      });
    });
  }
  render() {
    return (
      <div>
        <h2 className="text-center">GuardTraining List</h2>
        <div className="row">
          <button className="btn btn-primary" onClick={this.addGuardTraining}>
            Add Guard Training
          </button>
        </div>
        <div className="row">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th>Name</th>
                <th>Mobile No</th>
                <th>Status</th>
                <th>Timing</th>
                <th>Date</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {this.state.guardTraining.map((guardtraining) => (
                <tr key={guardtraining.userId}>
                  <td>{guardtraining.name}</td>
                  <td>{guardtraining.mobileNo}</td>
                  <td>{guardtraining.status}</td>
                  <td>{guardtraining.timing}</td>
                  <td>{guardtraining.date}</td>
                  <td>
                    <button
                      onClick={() =>
                        this.editGuardTraining(guardtraining.userId)
                      }
                      className="btn btn-info"
                    >
                      Update
                    </button>
                    <button
                      style={{ marginLeft: "10px" }}
                      onClick={() => this.deleteGuardTraining(guardtraining.id)}
                      className="btn btn-danger"
                    >
                      Delete
                    </button>
                    <button
                      style={{ marginLeft: "10px" }}
                      onClick={() =>
                        this.viewGuardTraining(guardtraining.userId)
                      }
                      className="btn btn-info"
                    >
                      View
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default ListGuardTrainingComponent;
