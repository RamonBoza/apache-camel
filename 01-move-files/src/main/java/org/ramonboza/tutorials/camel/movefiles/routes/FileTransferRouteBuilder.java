package org.ramonboza.tutorials.camel.movefiles.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by ramon.boza on 21/3/16.
 */
public class FileTransferRouteBuilder extends RouteBuilder {

	public enum FileTransferType {
		COPY_WITHOUT_IMPACTING_ORIGINALS("C"), COPY_WITH_ARCHIVED_ORIGINALS("A"), MOVE("M");

		private final String letter;

		FileTransferType(final String newLetter) {
			this.letter = newLetter;
		}

		public String getLetter() {
			return this.letter;
		}

		public static FileTransferType fromLetter(final String letter) {
			FileTransferType match = null;
			for (final FileTransferType type : FileTransferType.values()) {
				if (type.getLetter().equalsIgnoreCase(letter)) {
					match = type;
					break;
				}
			}
			return match;
		}
	}

	private final String fromEndPointString;
	private final static String FROM_BASE = "file:/tmp";
	private final static String FROM_NOOP = FROM_BASE + "?noop=true";
	private final static String FROM_MOVE = FROM_BASE + "?delete=true";
	private final static String CAMEL_OUTPUT_FOLDER = "file:/tmp/camel";

	public FileTransferRouteBuilder(final FileTransferType newFileTransferType) {
		if (newFileTransferType != null) {
			switch (newFileTransferType) {
				case COPY_WITHOUT_IMPACTING_ORIGINALS :
					this.fromEndPointString = FROM_NOOP;
					break;
				case COPY_WITH_ARCHIVED_ORIGINALS :
					this.fromEndPointString = FROM_BASE;
					break;
				case MOVE :
					this.fromEndPointString = FROM_MOVE;
					break;
				default :
					this.fromEndPointString = FROM_NOOP;
			}
		} else {
			fromEndPointString = FROM_NOOP;
		}
	}

	@Override
	public void configure() throws Exception {
		from(this.fromEndPointString).to(CAMEL_OUTPUT_FOLDER);
	}
}