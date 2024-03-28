package dev.ioliver.noterbackend.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DOCUMENTS")
public class Document {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Builder.Default private String title = "";

  @Builder.Default
  @Column(columnDefinition = "TEXT")
  private String content = "";
}
