package com.zaid.services;

import com.zaid.exceptions.InvalidGateException;
import com.zaid.models.Gate;
import com.zaid.models.Ticket;
import com.zaid.models.VehicleType;
import com.zaid.repositories.GateRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private final GateRepository gateRepository;

    public TicketService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Ticket issueTicket(Long gateId, String vehicleNumber, VehicleType vehicleType, String ownerName) throws InvalidGateException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Optional<Gate> optionalGate = gateRepository.findById(gateId);

        if (optionalGate.isEmpty()) {
            throw new InvalidGateException("Invalid gate Id");
        }

        Gate gate = optionalGate.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

        return null;
    }
}
