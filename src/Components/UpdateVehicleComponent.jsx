import React, { Component } from "react";
import VehicleService from "../services/VehicleService";

let today = new Date();

const regExp1 = RegExp(/^[0-9]+$/);
const regExp2 = RegExp(/^[0-5]+$/);

const formValid = ({ isError, ...rest }) => {
  let valid = true;

  Object.values(isError).forEach((val) => {
    val.length > 0 && (valid = false);
  });

  Object.values(rest).forEach((val) => {
    val == null && (valid = false);
  });

  return valid;
};

class UpdateVehicleComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      createdBy: "",
      modifiedBy: "",
      name: "",
      parkingNo: "",
      arrivalTime: "",
      departureTime: "",
      vehicleNo: this.props.match.params.vehicleNo,
      id: "",
      vehicleType: "",
      isError: { 
        createdBy: "",
        modifiedBy: "",
        name: "",
        parkingNo: "",
        vehicleNo: "", 
      },
      disabled: true,
    };

    this.changeCreatedByHandler = this.changeCreatedByHandler.bind(this);
    this.changeModifiedByHandler = this.changeModifiedByHandler.bind(this);
    this.changeNameHandler = this.changeNameHandler.bind(this);
    this.changeParkingNoHandler = this.changeParkingNoHandler.bind(this);
    this.changeArrivalTimeHandler = this.changeArrivalTimeHandler.bind(this);
    this.changeDepartureTimeHandler = this.changeDepartureTimeHandler.bind(this);
    this.changeVehicleNoHandler = this.changeVehicleNoHandler.bind(this);
    this.changeIdHandler = this.changeIdHandler.bind(this);
    this.changeVehicleTypeHandler = this.changeVehicleTypeHandler.bind(this);

    this.updateVehicle = this.updateVehicle.bind(this);
  }

  componentDidMount() {
    VehicleService.getVehiclesByVehicleNo(this.state.vehicleNo).then(
      (res) => {
        let vehicle = res.data;
        this.setState({
          createdBy: vehicle.createdBy,
          modifiedBy: vehicle.modifiedBy,
          name: vehicle.name,
          parkingNo: vehicle.parkingNo,
          arrivalTime: vehicle.arrivalTime,
          departureTime: vehicle.departureTime,
          vehicleNo: vehicle.vehicleNo,
          id: vehicle.id,
          vehicleType: vehicle.vehicleType,
        });
      }
    );
  }

  updateVehicle = (e) => {
    e.preventDefault();
    if(formValid(this.state))
    {
    let vehicle = {
      createdBy: this.state.createdBy,
      modifiedBy: this.state.modifiedBy,
        name: this.state.name,
        parkingNo: this.state.parkingNo,
        arrivalTime: this.state.arrivalTime,
        departureTime: this.state.departureTime,
        vehicleNo: this.state.vehicleNo,
        id: this.state.id,
        vehicleType: this.state.vehicleType,  
        date: today,
    };
    console.log("vehicle => " + JSON.stringify(vehicle));

    VehicleService.updateVehicle(vehicle, this.state.vehicleNo).then(
      (res) => {
        this.props.history.push("");
        alert("Form is valid")
      }
    );}
    else{
      alert("Form is invalid")
    } 
  };

  changeCreatedByHandler = (event) => {
    this.setState({ createdBy: event.target.value });
  };

  changeModifiedByHandler = (event) => {
    this.setState({ modifiedBy: event.target.value });
  };

  changeNameHandler = (event) => {
    this.setState({ name: event.target.value });
  };

  changeParkingNoHandler = (event) => {
    this.setState({ parkingNo: event.target.value });
  };

  changeArrivalTimeHandler = (event) => {
    this.setState({ arrivalTime: event.target.value });
  };

  changeDepartureTimeHandler = (event) => {
    this.setState({ departureTime: event.target.value });
  };

  changeVehicleNoHandler = (event) =>{
    this.setState({ vehicleNo: event.target.value});
  };
  
  changeIdHandler = (event) => {
    this.setState({ id: event.target.value });
  };

  changeVehicleTypeHandler = (event) => {
    this.setState({ vehicleType: event.target.value });
  };

  changeDateHandler = (event) => {
    this.setState({ today: event.target.value });
  };

 formValChange = (e) => {
    e.preventDefault();
    const { name, value } = e.target;
    let isError = { ...this.state.isError };
    switch (name) {
      case "createdBy":
        isError.createdBy =
          value.length < 5 ? "Atleast 5 characters required" : "";
        break;

      case "modifiedBy":
        isError.modifiedBy =
          value.length < 5 ? "Atleast 5 characters required" : "";
        break;

      case "name":
        isError.name = value.length < 2 ? "Atleast 2 characters required" : "";
        break;

      case "parkingNo":
        isError.parkingNo = value.length < 2 ? "Atleast 2 characters required" : "";
        break;

      case "vehicleNo":
        isError.vehicleNo = regExp1.test(value) ? "" : "Number is Invalid (used before)";
        break;
    
      default:
        break;
    }
    this.setState(
      {
        isError,
        [name]: value,
        disabled: false,
      },
      () => console.log(this.state)
    );
  };    
  cancel() {
    this.props.history.push("");
  }
  render() {    
    const { isError } = this.state;

    return (
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <h3 className="text-center">Update Vehicle</h3>
            <div className="card-body">
              <form>
               <div className="form-group">
                  <label>Modified By</label>
                  <input
                    placeholder="modifiedBy"
                    name="modifiedBy"
                    className={
                      isError.modifiedBy.length > 0
                        ? "is-invalid form-control"
                        : "form-control"
                    }
                    value={this.state.modifiedBy}
                    noValidate
                    onChange={
                      (this.changeModifiedByHandler, this.formValChange)
                    }
                  />
                  {isError.modifiedBy.length > 0 && (
                    <span className="invalid-feedback">
                      {isError.modifiedBy}
                    </span>
                  )}
                </div>

                <div className="form-group">
                  <label>Name</label>
                  <input
                    placeholder="Name"
                    name="name"
                    className={
                      isError.name.length > 0
                        ? "is-invalid form-control"
                        : "form-control"
                    }
                    value={this.state.name}
                    onChange={(this.changeNameHandler, this.formValChange)}
                  />
                  {isError.name.length > 0 && (
                    <span className="invalid-feedback">{isError.name}</span>
                  )}
                </div>
                <div className="form-group">
                  <label>Parking Number</label>
                  <input
                    placeholder="Parking Number"
                    name="parkingNo"
                    className={
                      isError.parkingNo.length > 0
                        ? "is-invalid form-control"
                        : "form-control"
                    }
                    value={this.state.parkingNo}
                    onChange={(this.changeParkingNoHandler, this.formValChange)}
                  />
                  {isError.parkingNo.length > 0 && (
                    <span className="invalid-feedback">{isError.parkingNo}</span>
                  )}
                </div>
                <div className="form-group">
                  <label>Arrival Time</label>
                  <input
                    placeholder="Arrival Time"
                    name="arrivalTime"
                    className="form-control"
                    value={this.state.arrivalTime}
                    onChange={this.changeArrivalTimeHandler}
                  />
                </div>
                <div className="form-group">
                  <label>Departure Time</label>
                  <input
                    placeholder="Departure Time"
                    name="departureTime"
                    className="form-control"
                    value={this.state.departureTime}
                    onChange={this.changeDepartureTimeHandler}
                  />
                </div>
                <div className="form-group">
                    <label>Date</label>
                    <input
                    placeholder="Date"
                    name="date"
                    className="form-control"
                    value={today}
                    onChange={this.changeDateHandler}
                    />
                    </div>

                <div className="form-group">
                  <label>Vehicle Number</label>
                  <input
                    placeholder="Vehicle Number"
                    name="vehicleNo"
                    className={
                      isError.vehicleNo.length > 0
                        ? "is-invalid form-control"
                        : "form-control"
                    }
                    value={this.state.vehicleNo}
                    onChange={(this.changeVehicleNoHandler, this.formValChange)}
                  />
                  {isError.vehicleNo.length > 0 && (
                    <span className="invalid-feedback">{isError.vehicleNo}</span>
                  )}
                </div>

                <div className="form-group">
                  <label>Vehicle Type </label>
                  <br></br>
                  <select  className="form-control"
                    name="vehicleType"
                    id="vehicleType"
                    value={this.state.vehicleType}
                    noValidate
                    onChange={this.changeVehicleTypeHandler}
                  >
                    <option value="SUV"> SUV</option>
                    <option value="Sedan"> Sedan </option>
                    <option value="Hatchback"> Hatchback </option>
                    <option value="Crossover"> Crossover </option>
                    <option value="F1"> F1 </option>
                    <option value="Scooty"> Scooty </option>
                    <option value="Motor Cycle"> Motor Cycle </option>
                    <option value="Cycle">Cycle</option>
                  </select>
                </div>
                

                <button disabled={this.state.disabled}
                  className="btn btn-success"
                  onClick={this.updateVehicle}
                >
                  Save
                </button>

                <button
                  className="btn btn-danger"
                  onClick={this.cancel.bind(this)}
                  style={{ marginLeft: "10px" }}
                >
                  Cancel
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default UpdateVehicleComponent;

