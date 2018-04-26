package com.tukkijamm.backend.beanconvertor.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tukkijamm.backend.beanconvertor.service.ReservationApiService;
import com.tukkijamm.backend.dto.ReservationDTO;
import com.tukkijamm.backend.model.Reservation;

@Service("reservationApiService")
public class ReservationApiServiceImpl implements ReservationApiService {

	@Override
	public ReservationDTO convertReservationToReservationDTO(Reservation reservation) {
		ReservationDTO reservationDTO = new ReservationDTO();
		if (reservation!=null){
			reservationDTO.setId(reservation.getId());
			reservationDTO.setStatus(reservation.getStatus());
			reservationDTO.setDeletedOwner(reservation.getDeletedOwner());
		}
		return reservationDTO;
	}

	@Override
	public List<ReservationDTO> convertoReservationListToReservationDTOList(List<Reservation> reservations) {
		List<ReservationDTO> reservationDTOList = new ArrayList<ReservationDTO>();
		for (Reservation reservation : reservations) {
			reservationDTOList.add(convertReservationToReservationDTO(reservation));
		}
		return reservationDTOList;
	}

}
