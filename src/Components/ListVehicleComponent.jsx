import React, { Component } from 'react';
import VehicleService from '../services/VehicleService';

class ListVehicleComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            vehicle: [],
            
        }
        this.addVehicle = this.addVehicle.bind(this);
        this.editVehicle = this.editVehicle.bind(this);
        this.deleteVehicle = this.deleteVehicle.bind(this);
    }

    baseEntity(vehicleNo) {
      this.props.history.push(`/getByPk/${vehicleNo}`);
    }
    
    editVehicle(vehicleNo){
      this.props.history.push(`/update-Vehicle/${vehicleNo}`);  
    }

    componentDidMount(){
        VehicleService.getVehicles().then((res)=> {
            this.setState({ vehicle: res.data});
        })
    }
        
    addVehicle(){
      this.props.history.push('/add-Vehicle')
    }
    viewVehicle(vehicleNo) {
      this.props.history.push(`/getById/${vehicleNo}`);
    }
     deleteVehicle(id) {
      VehicleService.deleteVehicle(id).then((res) => {
        this.setState({
          vehicle: this.state.vehicle.filter(
            (vehicle) => vehicle.id !== id
          ),
        });
      });
    }

    render() {
        return (
          <div>
            <h2 className="text-center">Vehicle List</h2>
            <div className="row">
            <button className="btn btn-primary" onClick={this.addVehicle}>
            Add Vehicle
          </button>
              <table className="table table-striped table-bordered">
                <thead>
                  <tr>
                    <th>Name</th>
                    <th>Parking Number</th>
                    <th>Arrival Time</th>
                    <th>Departure Time</th>
                    <th>Date</th>
                    <th>Vehicle Type</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  {this.state.vehicle.map((vehicle) => (
                    <tr key={vehicle.vehicleNo}>
                      <td>{vehicle.name}</td>
                      <td>{vehicle.parkingNo}</td>
                      <td>{vehicle.arrivalTime}</td>
                      <td>{vehicle.departureTime}</td>
                      <td>{vehicle.date}</td>
                      <td>{vehicle.vehicleType}</td>
                      <td>
                    <button
                      onClick={() =>
                        this.editVehicle(vehicle.vehicleNo) 
                      }
                      className="btn btn-info"
                    >
                      Update
                    </button>
                    <button
                      style={{ marginLeft: "10px" }}
                      onClick={() => this.deleteVehicle(vehicle.id)} 
                      className="btn btn-danger"
                    >
                      Delete
                    </button>
                    <button
                      style={{ marginLeft: "10px" }}
                      onClick={() =>
                        this.viewVehicle(vehicle.vehicleNo)
                      }
                      className="btn btn-info"
                    >
                      View
                    </button>
                    <button
                      style={{ marginLeft: "10px" }}
                      onClick={() => this.baseEntity(vehicle.vehicleNo)}
                      className="btn btn-info"
                    >
                      Audit
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

export default ListVehicleComponent;