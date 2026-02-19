package com.services;

import com.dtos.PaymentDto;

import java.util.List;

/**
 * Interface définissant les opérations métier disponibles pour la gestion des payements.
 * Cette interface suit le principe d'Interface Segregation (SOLID).
 */
public interface PaymentService {
    /**
     * Sauvegarde un payement dans le système
     * @param paymentDto les données du payement à sauvegarder
     * @return le payement sauvegardé avec son ID généré
     */
    PaymentDto savePayment(PaymentDto paymentDto);

    /**
     * Récupère un payement par son identifiant
     * @param paymentId l'identifiant du payement recherché
     * @return le payement trouvé
     * @throws jakarta.persistence.EntityNotFoundException si le payement n'existe pas
     */
    PaymentDto getPaymentById(Long paymentId);

    /**
     * Supprime un payement du système
     * @param paymentId l'identifiant du payement à supprimer
     * @return true si la suppression a réussi
     */
    boolean deletePayment(Long paymentId);

    /**
     * Récupère tous les payements du système
     * @return la liste des payements
     */
    List<PaymentDto> getAllPayments();
}
